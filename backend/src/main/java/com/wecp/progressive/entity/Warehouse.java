package com.wecp.progressive.entity;

public class Warehouse implements Comparable<Warehouse> {
    int warehouseId;
    int supplierId;
    String warehouseName;
    String location;
    int capacity;
    
    public Warehouse(int warehouse_id, int supplier_id, String warehouse_name, String location, int capacity) {
        this.warehouseId = warehouse_id;
        this.supplierId = supplier_id;
        this.warehouseName = warehouse_name;
        this.location = location;
        this.capacity = capacity;
    }
    public Warehouse () {}
    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int warehouse_id) {
        this.warehouseId = warehouse_id;
    }
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplier_id) {
        this.supplierId = supplierId;
    }
    public String getWarehouseName() {
        return warehouseName;
    }
    public void setWarehouseName(String warehouse_name) {
        this.warehouseName = warehouse_name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public int compareTo(Warehouse o) {
        // TODO Auto-generated method stub
        return this.capacity - o.getCapacity();
    }

    

}