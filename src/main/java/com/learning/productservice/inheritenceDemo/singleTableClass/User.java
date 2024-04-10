package com.learning.productservice.inheritenceDemo.singleTableClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_table_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
)

@DiscriminatorValue(value = "0")
public class User {
    @Id
    private long id;
    private String name;
    private String password;
}
