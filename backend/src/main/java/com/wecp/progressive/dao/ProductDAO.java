package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
<<<<<<< HEAD
    int addProduct(Product product) throws SQLException;
=======
    int addProduct(Product accounts) throws SQLException;
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
    Product getProductById(int productId) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(int productId) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
}