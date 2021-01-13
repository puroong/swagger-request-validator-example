package com.example.swagger.request.validator.example;

import java.util.Optional;

public class PostRequest {
    private String value1;

    public PostRequest() {
    }

    public PostRequest(String value1) {
        this.value1 = value1;
    }

    @Override
    public String toString() {
        return value1;
    }

    public String getValue1() {
        return value1;
    }
}
