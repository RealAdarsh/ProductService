package com.learning.productservice.services;

import com.learning.productservice.dtos.fakeStoreProductDto;
import com.learning.productservice.models.Category;
import com.learning.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        fakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class );

        assert fakeStoreProductDto != null;
        return convertFakeStoreProductServiceToProduct(fakeStoreProductDto);
    }
    @Override
    public Product addNewProduct(Product product) {
//        fakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
//        ResponseEntity<fakeStoreProductDto> responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto.class, fakeStoreProductDto);
//
//        return convertFakeStoreProductServiceToProduct(responseDto);
        return new Product();
    }


    public Product convertFakeStoreProductServiceToProduct(fakeStoreProductDto fakeStoreProductDto){
        Product product= new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage_url(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());

        return product;

    }

    public fakeStoreProductDto convertProductToFakeStoreProductDto(Product product){
        fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setImage(product.getImage_url());
        fakeStoreProductDto.setDescription(product.getDescription());

        return fakeStoreProductDto;
    }
}
