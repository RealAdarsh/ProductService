package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    void getAllProducts();

    void deleteProductsById();

    void createProduct();
    void updateProductById();
}
