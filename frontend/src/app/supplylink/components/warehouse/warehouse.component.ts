import { Component } from "@angular/core";
import { FormBuilder } from "@angular/forms";

@Component ({
    selector : 'app-warehouse',
    template : './warehouse.component.html',
    styleUrls : ['./warehouse.component.scss']
})

export class WarehouseComponent {

    
    constructor (private fb : FormBuilder) {}

}
