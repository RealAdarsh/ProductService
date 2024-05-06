package com.learning.productservice.repositories;

import com.learning.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    // HQL
    @Query("SELECT p.id, p.price  from Product p where p.id=51")
    List<ProductWithIDandPrice> somethingsomething();

//    @Query(value = "", nativeQuery = true)


}
