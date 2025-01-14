<<<<<<< HEAD

package com.wecp.progressive.service.impl;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.exception.NoWarehouseFoundForSupplierException;
=======
package com.wecp.progressive.service.impl;

import com.wecp.progressive.entity.Warehouse;
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

<<<<<<< HEAD
import javax.transaction.Transactional;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Autowired
    ProductRepository productRepository;

=======
@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    @Autowired
    ProductRepository productRepository;

    private WarehouseRepository warehouseRepository;

>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
    @Autowired
    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return warehouseRepository.findAll();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        return warehouseRepository.save(warehouse).getWarehouseId();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        List<Warehouse> sortedWarehouses = warehouseRepository.findAll();
        Collections.sort(sortedWarehouses);
        return sortedWarehouses;
    }

    @Override
<<<<<<< HEAD
    @Transactional
=======
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseRepository.save(warehouse);
    }

    @Override
<<<<<<< HEAD
    @Transactional
=======
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
    public void deleteWarehouse(int warehouseId) throws SQLException {
        productRepository.deleteByWarehouseId(warehouseId);
        warehouseRepository.deleteById(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    @Override
<<<<<<< HEAD
    public List<Warehouse> getWarehouseBySupplier(int supplierId) throws NoWarehouseFoundForSupplierException {
        List<Warehouse> warehouseList = warehouseRepository.findAllBySupplier_SupplierId(supplierId);
        if (warehouseList.isEmpty()) {
            throw new NoWarehouseFoundForSupplierException("Cannot find warehouse by this supplier id");
        }
        return warehouseList;
    }
}
=======
    public List<Warehouse> getWarehouseBySupplier(int supplierId) throws SQLException {
        return warehouseRepository.findAllBySupplier_SupplierId(supplierId);
    }
}
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
