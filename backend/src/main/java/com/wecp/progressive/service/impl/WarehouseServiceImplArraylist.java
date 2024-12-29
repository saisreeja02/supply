package com.wecp.progressive.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService  {

    public List<Warehouse> wareHouseList = new ArrayList<>();

    @Override
    public List<Warehouse> getAllWarehouses() {
        // TODO Auto-generated method stub
        return wareHouseList;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        // TODO Auto-generated method stub
        wareHouseList.add(warehouse);
        return wareHouseList.size();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        // TODO Auto-generated method stub
        Collections.sort(wareHouseList);
        return wareHouseList;
    }

}

