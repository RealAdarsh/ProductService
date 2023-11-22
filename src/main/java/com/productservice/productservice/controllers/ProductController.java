package com.productservice.productservice.controllers;

import com.productservice.productservice.Services.FakeStoreProductService;
import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    // Constructor Injection
    ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        // call the FakeStoreProduct Service getProductById() method
//        return "Scaler || Product fetched with Id : " + id;

        return productService.getProductById(id);
    }

    @GetMapping()
    public void getAllProducts(){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }

    public void createProduct(){

    }
}
