package com.learning.productservice.services;

import com.learning.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(long id);
    public Product addNewProduct(Product product);
    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, Product product);

    public Product updateProduct(Long id, Product product);

    public void deleteProduct(Long id);
}
