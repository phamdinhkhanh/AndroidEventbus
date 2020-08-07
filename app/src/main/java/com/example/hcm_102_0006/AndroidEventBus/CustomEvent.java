package com.example.hcm_102_0006.AndroidEventBus;

/**
 * Created by hcm-102-0006 on 06/04/2018.
 */

public class CustomEvent {
    private String name;
    private String password;


    public CustomEvent(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
