package com.example.JavaOngageAPI;

import java.util.HashMap;

public class User {
    private HashMap<String, Object> data;

    public User(HashMap<String, Object> data) {
        this.data = data;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}