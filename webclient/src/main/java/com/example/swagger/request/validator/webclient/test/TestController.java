package com.example.swagger.request.validator.webclient.test;

import com.example.swagger.request.validator.webclient.test.request.PostTestRequest;
import com.example.swagger.request.validator.webclient.test.response.GetTestResponse;
import com.example.swagger.request.validator.webclient.test.response.PostTestResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation("get test")
    @ApiResponses({
        @ApiResponse(code = 200, message = "success"),
        @ApiResponse(code = 400, message = "bad request"),
        @ApiResponse(code = 401, message = "unauthorized"),
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetTestResponse getTest(
        @RequestParam int query
    ) {
        if(query == 401) throw new ResponseStatusException(401, null, null);
        if(query != 200) throw new ResponseStatusException(400, null, null);

        return new GetTestResponse("test");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("post test")
    @ApiResponses({
        @ApiResponse(code = 201, message = "success"),
        @ApiResponse(code = 400, message = "bad request"),
        @ApiResponse(code = 401, message = "unauthorized"),
    })
    public PostTestResponse postTest(
        @Valid @RequestBody PostTestRequest postTestRequest
    ) {
        int value = postTestRequest.getValue();
        if(value == 401) throw new ResponseStatusException(401, null, null);
        if(value != 200) throw new ResponseStatusException(400, null, null);

        return new PostTestResponse("test");
    }
}
