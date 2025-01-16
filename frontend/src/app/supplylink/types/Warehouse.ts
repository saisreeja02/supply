import { Supplier } from "./Supplier";
 
export class Warehouse {
    public warehouseId: number;
    public supplierId: string;
    public warehouseName: string;
    public location: string;
    public capacity: number;
 
    constructor(warehouseId: number, supplierId: string, warehouseName: string, location: string, capacity: number) {
        this.warehouseId = warehouseId;
        this.supplierId = supplierId;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
    }
 
    public displayInfo(): void {
        console.log(`Warehouse ID: ${this.warehouseId}`);
        console.log(`Supplier ID: ${this.supplierId}`);
        console.log(`Capacity: ${this.capacity}`);
        // console.log(`Warehouse Name: ${this.warehouseName}`);
        // console.log(`Location: ${this.location}`);
    }
}
