package com.wecp.progressive.service.impl;

<<<<<<< HEAD
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.ProductDAO;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.exception.InsufficientCapacityException;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa implements ProductService  {

    private ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    public ProductServiceImplJpa (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
   
    @Override
    public List<Product> getAllProducts() {
=======
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImplJpa  implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        return productRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Product getProductById(int productId) {
=======
    public Product getProductById(int productId) throws SQLException {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        return productRepository.findByProductId(productId);
    }

    @Override
<<<<<<< HEAD
    public int addProduct(Product product) {
        if(product.getWarehouse().getCapacity() < 1)
            throw new InsufficientCapacityException("Warehouse full");
=======
    public int addProduct(Product product) throws SQLException {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        return productRepository.save(product).getProductId();
    }

    @Override
<<<<<<< HEAD
    @Transactional
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
        
    }

    public List<Product> getAllProductByWarehouse(int warehouseId) {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }

=======
    public void updateProduct(Product product) throws SQLException {
        productRepository.save(product).getProductId();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
}