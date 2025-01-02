package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.service.impl.SupplierServiceImplArraylist;
import com.wecp.progressive.service.impl.SupplierServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        try {
            return new ResponseEntity<>(supplierServiceImplJpa.getAllSuppliers(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }   
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) {
        try {
            return new ResponseEntity<>(supplierServiceImplJpa.getSupplierById(supplierId), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        try {
            return new ResponseEntity<>(supplierServiceImplJpa.addSupplier(supplier), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping()
    public ResponseEntity<?> updateSupplier( @RequestBody Supplier supplier) {
        try {
            supplierServiceImplJpa.updateSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<?> deleteSupplier(@PathVariable int supplierId) {
        try {
            supplierServiceImplJpa.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSupplierFromArrayList(){
        List<Supplier> s=supplierServiceImplArraylist.getAllSuppliers();
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        int listSize=supplierServiceImplArraylist.addSupplier(supplier);
        return new ResponseEntity<>(listSize, HttpStatus.CREATED);
        
    }
    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> s=supplierServiceImplArraylist.getAllSuppliersSortedByName();
        return new ResponseEntity<>(s, HttpStatus.OK);
       
    }

}