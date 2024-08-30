package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private final MyTeam myTeam;

    @Autowired
    public MyComponent( MyTeam myTeam) {
        this.myTeam = myTeam;
    }

}
