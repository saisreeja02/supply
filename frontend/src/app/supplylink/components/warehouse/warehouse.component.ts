import { Component } from "@angular/core";
import { AbstractControl, FormBuilder, FormGroup, NgControlStatus, ValidationErrors, Validators } from "@angular/forms";
import { map, Observable, of } from "rxjs";
import { SupplyLinkService } from "../../services/supplylink.service";

@Component ({
    selector : 'app-warehouse',
    template : './warehouse.component.html',
    styleUrls : ['./warehouse.component.scss']
})

export class WarehouseComponent {

  warehouseForm: FormGroup;
  warehouseError$: Observable<string>;
  warehouseSuccess$: Observable<string>;

  constructor(private fb: FormBuilder, private service : SupplyLinkService) {
    this.warehouseError$ = of('');
    this.warehouseSuccess$ = of('');
  }

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      supplierId: ['', [Validators.required, this.validateSupplier]],
      warehouseName: ['', Validators.required, this.simulateBackendError],
      location : ['', [Validators.required]],
      capacity: [0, [Validators.required, this.validateNonNegativeCapacity]]
    });
  }

  onSubmit(): void {
    if (this.warehouseForm.valid) {
      const newSupplier = this.warehouseForm.value;
      console.log('New Supplier:', newSupplier);
      // Handle form submission, e.g., call a service to save the supplier
      this.warehouseSuccess$ = of('Supplier added successfully!');
      this.warehouseError$ = of('');
    } else {
      this.warehouseError$ = of('Form is invalid. Please fix the errors and try again.');
      this.warehouseSuccess$ = of('');
    }
  }

  validateSupplier (controls : AbstractControl) : ValidationErrors | null {
    if(controls.value == null) {
      return {null : false} 
    }
    return { null : true};
  }

  validateNonNegativeCapacity(controls : AbstractControl) :ValidationErrors | null {
    if(controls.value < 0)
        return { negative : true};
    return { negative : false};
  }

  simulateBackendError(controls : AbstractControl):ValidationErrors | null {
    return this.service.getAllWarehouses().pipe(
      map((warehouses) => {
        warehouses.forEach((warehouse) => {
          const comparisonResult = warehouse.warehouseName.localeCompare(controls.value);
          if(comparisonResult) {
            return {similar : true};
          }
        });
        return {similar : false};
      })
    );
  }
}
