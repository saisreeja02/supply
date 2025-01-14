package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Product;
import com.wecp.progressive.service.impl.ProductServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImplJpa productServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws SQLException {
        List<Product> products = productServiceImplJpa.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        try {
            Product product = productServiceImplJpa.getProductById(productId);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
<<<<<<< HEAD
        } catch (Exception e) {
=======
        } catch (SQLException e) {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            int productId = productServiceImplJpa.addProduct(product);
            return new ResponseEntity<>(productId, HttpStatus.CREATED);
        } catch (Exception e) {
            // Return a generic error message for any other exceptions
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
=======
    public ResponseEntity<Integer> addProduct(@RequestBody Product product) {
        try {
            int productId = productServiceImplJpa.addProduct(product);
            return new ResponseEntity<>(productId, HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        try {
            product.setProductId(productId);
            productServiceImplJpa.updateProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
<<<<<<< HEAD
        } catch (Exception e) {
=======
        } catch (SQLException e) {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        try {
            productServiceImplJpa.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
<<<<<<< HEAD
        } catch (Exception e) {
=======
        } catch (SQLException e) {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Product>> getAllProductByWarehouse(@PathVariable int warehouseId) throws SQLException {
        List<Product> products = productServiceImplJpa.getAllProductByWarehouse(warehouseId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}