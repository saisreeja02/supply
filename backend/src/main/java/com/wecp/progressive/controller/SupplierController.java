package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Supplier;
<<<<<<< HEAD
import com.wecp.progressive.exception.SupplierAlreadyExistsException;
import com.wecp.progressive.exception.SupplierDoesNotExistException;
=======
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
import com.wecp.progressive.service.impl.SupplierServiceImplArraylist;
import com.wecp.progressive.service.impl.SupplierServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = supplierServiceImplJpa.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{supplierId}")
<<<<<<< HEAD
    public ResponseEntity<?> getSupplierById(@PathVariable int supplierId) throws SQLException {
        try {
            Supplier supplier = supplierServiceImplJpa.getSupplierById(supplierId);
                return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (SupplierDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Return a generic error message for any other exceptions
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
=======
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) throws SQLException {
        try {
            Supplier supplier = supplierServiceImplJpa.getSupplierById(supplierId);
            if (supplier != null) {
                return new ResponseEntity<>(supplier, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        }
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
        try {
            int supplierId = supplierServiceImplJpa.addSupplier(supplier);
            return new ResponseEntity<>(supplierId, HttpStatus.CREATED);
        } catch (SupplierAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
=======
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        try {
            int supplierId = supplierServiceImplJpa.addSupplier(supplier);
            return new ResponseEntity<>(supplierId, HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        }
    }

    @PutMapping("/{supplierId}")
<<<<<<< HEAD
    public ResponseEntity<?> updateSupplier(@PathVariable int supplierId, @RequestBody Supplier supplier) {
=======
    public ResponseEntity<Void> updateSupplier(@PathVariable int supplierId, @RequestBody Supplier supplier) {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        try {
            supplier.setSupplierId(supplierId);
            supplierServiceImplJpa.updateSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
<<<<<<< HEAD
        } catch (SupplierAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
=======
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        }
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) {
        try {
            supplierServiceImplJpa.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        List<Supplier> suppliers = supplierServiceImplArraylist.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        int listSize = supplierServiceImplArraylist.addSupplier(supplier);
        return new ResponseEntity<>(listSize, HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> supplierList = supplierServiceImplArraylist.getAllSuppliersSortedByName();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }
}