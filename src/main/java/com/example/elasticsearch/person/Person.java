package com.example.elasticsearch.person;

import java.io.Serializable;
import java.lang.String;

import org.springframework.stereotype.Component;


public class Person {
    private String name;
    private int age;
    private boolean engaged;
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEngaged() {
        return engaged;
    }

    public void setEngaged(boolean engaged) {
        this.engaged = engaged;
    }

    public Person(String name, int age, boolean engaged){
        this.name = name;
        this.age = age;
        this.engaged = engaged;
    }
    
}
