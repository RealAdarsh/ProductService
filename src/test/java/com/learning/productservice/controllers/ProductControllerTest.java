package com.learning.productservice.controllers;

import com.learning.productservice.models.Product;
import com.learning.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testProductSameAsService(){
        // arranging the mock
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setTitle("iphone 15");
        products.add(p1);

        Product p2 = new Product();
        p2.setTitle("iphone 15 pro");
        products.add(p2);

        Product p3 = new Product();
        p2.setTitle("iphone 15 pro max");
        products.add(p3);

        when(
                productService.getAllProducts()
        ).thenReturn(
                products
        );

        ResponseEntity<List<Product>> response = productController.getAllProducts(
//                ""
        );

        List<Product> productsInResponse = response.getBody();

        assertEquals(products.size(), productsInResponse.size());

        for (int i=0; i<productsInResponse.size(); i++){
            assertEquals(products.get(i).getTitle(), productsInResponse.get(i).getTitle());
        }

    }
}
