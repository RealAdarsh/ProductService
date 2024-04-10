package com.learning.productservice.inheritenceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "join_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    private int numberOfClasses;
}
