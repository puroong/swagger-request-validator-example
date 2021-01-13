package com.example.swagger.request.validator.webclient.test.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostTestRequest {
    @NotNull
    private int value;
}
