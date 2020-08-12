package com.example.demo.Models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String secret;
    private String org;

    public User() throws Exception {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getName() { return this.name; }
    public String getSecret() { return this.secret; }
    public String getOrg() { return this.org; }
}
