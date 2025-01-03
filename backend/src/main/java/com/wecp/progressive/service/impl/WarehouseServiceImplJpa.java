package com.wecp.progressive.service.impl;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return List.of();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        return List.of();
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {

    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {

    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return null;
    }
}