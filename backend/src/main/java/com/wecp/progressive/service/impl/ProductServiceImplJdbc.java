package com.wecp.progressive.service.impl;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

=======
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
import com.wecp.progressive.dao.ProductDAO;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.service.ProductService;

<<<<<<< HEAD
public class ProductServiceImplJdbc implements ProductService  {

    private ProductDAO productDAO;

    public ProductServiceImplJdbc (ProductDAO productDAO) {
=======
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImplJdbc implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productDAO.getProductById(productId);
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        return productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
<<<<<<< HEAD
       productDAO.deleteProduct(productId);
    }


=======
        productDAO.deleteProduct(productId);
    }
>>>>>>> faa153be23884f0dacdcc5916e85b4199048d011
}