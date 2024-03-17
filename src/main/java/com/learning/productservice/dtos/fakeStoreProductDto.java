package com.learning.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreProductDto {
    private Long id;
    private String title;
    private double Price;
    private String category;
    private String description;
    private String image;
}
