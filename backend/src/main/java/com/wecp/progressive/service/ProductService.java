package com.wecp.progressive.service;

import com.wecp.progressive.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws SQLException;

    Product getProductById(int productId) throws SQLException;

<<<<<<< HEAD
    int addProduct(Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;
=======
    int addProduct(Product Product) throws SQLException;

    void updateProduct(Product Product) throws SQLException;
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011

    void deleteProduct(int productId) throws SQLException;

    //Do not implement these methods in ProductServiceImplJdbc.java class
<<<<<<< HEAD
    public default List<Product> getAllProductByWarehouse(int warehouseId) {
        return null;
    }
}
=======
    default List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        return null;
    }
}
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
