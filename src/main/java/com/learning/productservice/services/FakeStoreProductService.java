package com.learning.productservice.services;

import com.learning.productservice.dtos.FakeStoreProductDto;
import com.learning.productservice.models.Category;
import com.learning.productservice.models.Product;
import exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class );
        if (fakeStoreProductDto==null){
            throw new ProductNotFoundException("Product Not Found");
        }
        return convertFakeStoreProductServiceToProduct(fakeStoreProductDto);
    }
    @Override
    public Product addNewProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        FakeStoreProductDto fakeStoreProductDto1= restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);

        assert fakeStoreProductDto1 != null;
        return convertFakeStoreProductServiceToProduct(fakeStoreProductDto1);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[]  fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeProducts : fakeStoreProductDto){
            products.add(convertFakeStoreProductServiceToProduct(fakeProducts));
        }

        return products;
    }

    @Override
    public Product replaceProduct(Long id, Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getDescription());
        fakeStoreProductDto.setImage(product.getImage_url());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto1= restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.POST, requestCallback, responseExtractor);

        assert fakeStoreProductDto1 != null;
        return convertFakeStoreProductServiceToProduct(fakeStoreProductDto1);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Product prevProduct = getSingleProduct(id);
        if (product.getCategory() != null) {
            prevProduct.setCategory(product.getCategory());
        }
        if (product.getDescription() != null) {
            prevProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != 0.0) {
            prevProduct.setPrice(product.getPrice());
        }
        if (product.getTitle() != null) {
            prevProduct.setTitle(product.getTitle());
        }
        if (product.getImage_url() != null) {
            prevProduct.setImage_url(product.getImage_url());
        }
        return replaceProduct(id, prevProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+ id);
        return ;
    }


    public Product convertFakeStoreProductServiceToProduct(FakeStoreProductDto fakeStoreProductDto){
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

    public FakeStoreProductDto convertProductToFakeStoreProductDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setImage(product.getImage_url());
        fakeStoreProductDto.setDescription(product.getDescription());

        return fakeStoreProductDto;
    }




}
