package com.learning.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class HelloClass {

    @GetMapping("/say/{name}/{times}")
    public String printName(@PathVariable("name") String name,
                            @PathVariable("times") int times){
        String ans = "";
        for (int i=0; i<times; i++){
            ans = ans + name + " ";
        }

//        List<String> l = getList();
        return ans;

    }
}

class Animal{
    private String name;
    public void fun(){
        System.out.println("I am Animal");
    }
}


