package com.example.swagger.request.validator.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetResponse get() {
        return new GetResponse("value");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse post(
        @RequestBody PostRequest postRequest
    ) {
        return new PostResponse(postRequest.toString());
    }
}
