import { Warehouse } from './Warehouse';
 
export class Product {
  public productId: number;
  public warehouseId: string;
  public productName: string;
  public productDescription: string;
  public quantity: number;
  public price: number;
 
  constructor(productId: number, warehouseId: string, productName: string, productDescription: string, quantity: number, price: number) {
    this.productId = productId;
    this.warehouseId = warehouseId;
    this.productName = productName;
    this.productDescription = productDescription;
    this.quantity = quantity;
    this.price = price;
  }
 
  public displayInfo(): void {
    console.log(`Product ID: ${this.productId}`);
    console.log(`Warehouse ID: ${this.warehouseId}`);
    console.log(`Product name: ${this.productName}`);
    console.log(`Product description: ${this.productDescription}`);
    console.log(`quantity: ${this.quantity}`);
    console.log(`price: ${this.price}`);
  }
}