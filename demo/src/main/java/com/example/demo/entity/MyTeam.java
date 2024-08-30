package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class MyTeam {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
