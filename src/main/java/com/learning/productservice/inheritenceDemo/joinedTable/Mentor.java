package com.learning.productservice.inheritenceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private String rating;
}
