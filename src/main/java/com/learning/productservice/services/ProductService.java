package com.learning.productservice.services;

import com.learning.productservice.models.Product;

public interface ProductService {
    public Product getSingleProduct(long id);
    public Product addNewProduct(Product product);
}
