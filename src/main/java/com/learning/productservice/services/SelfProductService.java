package com.learning.productservice.services;

import com.learning.productservice.models.Category;
import com.learning.productservice.models.Product;
import com.learning.productservice.repositories.CategoryRepository;
import com.learning.productservice.repositories.ProductRepository;
import exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class SelfProductService implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> productOptional= productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id = " + id + "doesn't exist.");
        }
        return productOptional.get();
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> categoryOptional= categoryRepository.findById(product.getCategory().getId());

        if (categoryOptional.isEmpty()) {
            categoryRepository.save(product.getCategory());
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        Optional <Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new NullPointerException();
        }

        Product existingProduct = optionalProduct.get();

        existingProduct.setTitle(product.getTitle());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setId(product.getId());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage_url(product.getImage_url());

        Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());

        if (optionalCategory.isEmpty()){
            categoryRepository.save(product.getCategory());
        }

        existingProduct.setCategory(product.getCategory());


        return productRepository.save(existingProduct);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional <Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new NullPointerException();
        }

        Product existingProduct = optionalProduct.get();
        if (existingProduct.getTitle()!=null){
            existingProduct.setTitle(product.getTitle());
        }

        if (existingProduct.getPrice()!=0){
            existingProduct.setPrice(product.getPrice());

        }
        if (existingProduct.getId()!=0){
            existingProduct.setId(product.getId());
        }
        if (existingProduct.getDescription()!=null){
            existingProduct.setDescription(product.getDescription());
        }

        if (existingProduct.getImage_url()!=null){
            existingProduct.setImage_url(product.getImage_url());
        }

        if (existingProduct.getCategory()!=null){
            Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());

            if (optionalCategory.isEmpty()){
                categoryRepository.save(product.getCategory());
            }

            existingProduct.setCategory(product.getCategory());

        }

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional <Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new NullPointerException();
        }

        Product product = productOptional.get();

        product.set_deleted(true);

        productRepository.save(product);
    }
}
