package com.learning.productservice.inheritenceDemo.singleTableClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_table_mentor")
@DiscriminatorValue("1")
public class Mentor extends User {
    private String rating;
}
