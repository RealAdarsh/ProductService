package com.learning.productservice.inheritenceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private long id;
    private String name;
    private String password;
}
