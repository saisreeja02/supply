package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wecp.progressive.dao.SupplierDAO;
import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.exception.SupplierDoesNotExistException;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.service.SupplierService;

public class SupplierServiceImplJpa implements SupplierService  {

    private SupplierDAO supplierDAO;

    public SupplierServiceImplJpa(SupplierDAO supplierDAO)  {
        this.supplierDAO = supplierDAO;
    }
    
    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers()throws SQLException {
        return supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier)throws SQLException {
        supplierRepository.save(supplier);
        return supplier.getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        List<Supplier> sup = supplierRepository.findAll();
        Collections.sort(sup);
        return sup;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        // if(!supplierRepository.existsById(supplier.getSupplierId())){
        //     throw new SupplierDoesNotExistException("Supplier with id" + supplier.getSupplierId() + " does not exists ");
        // }
        // // Supplier s = supplierRepository.findById(supplier.getSupplierId()).get();
        supplierRepository.save(supplier);
        
    }   

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        supplierRepository.deleteById(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        return supplierRepository.findById(supplierId).get();
    }

    

}