package com.learning.productservice.services;

import com.learning.productservice.models.Product;
import exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(long id) throws ProductNotFoundException;
    public Product addNewProduct(Product product);
    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, Product product);

    public Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    public void deleteProduct(Long id);
}
