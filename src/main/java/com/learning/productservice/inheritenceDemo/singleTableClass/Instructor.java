package com.learning.productservice.inheritenceDemo.singleTableClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "single_table_instructor")
@DiscriminatorValue("2")
public class Instructor extends User {
    private int numberOfClasses;
}
