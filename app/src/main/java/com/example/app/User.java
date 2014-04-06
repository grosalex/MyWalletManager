package com.example.app;

/**
 * Created by grosalex on 20/03/14.
 */
public class User {
    private String name;

    public User(String inName) {
        this.name = inName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }



}
