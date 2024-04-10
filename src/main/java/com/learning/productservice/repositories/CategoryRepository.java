package com.learning.productservice.repositories;

import com.learning.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(long id);
    Category save(Category category);
}
