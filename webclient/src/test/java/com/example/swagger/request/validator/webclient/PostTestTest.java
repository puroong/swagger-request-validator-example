package com.example.swagger.request.validator.webclient;

import com.example.swagger.request.validator.webclient.test.request.PostTestRequest;
import com.example.swagger.request.validator.webclient.test.response.PostTestResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTestTest extends ApiTest{
    private final String URL = "/test";

    @Test
    public void postTestSuccess() {
        System.out.println("postTestSuccess begin");
        RequestEntity<PostTestRequest> request = RequestEntity.post(URI.create("/test"))
            .body(new PostTestRequest(200));

        ResponseEntity<PostTestResponse> response = context.getRestTemplate().exchange(request, PostTestResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        System.out.println("postTestSuccess end");
    }

    @Test
    public void postTestFailBecause401Given() {
        System.out.println("postTestFail401 begin");
        RequestEntity<PostTestRequest> request = RequestEntity.post(URI.create("/test"))
            .body(new PostTestRequest(401));

        ResponseEntity<PostTestResponse> response = context.getRestTemplate().exchange(request, PostTestResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
        System.out.println("postTestFail401 end");
    }

    @Test
    public void postTestFailBecauseOtherThan401Or200Given() {
        System.out.println("postTestFail400 begin");
        RequestEntity<PostTestRequest> request = RequestEntity.post(URI.create("/test"))
            .body(new PostTestRequest(400));

        ResponseEntity<PostTestResponse> response = context.getRestTemplate().exchange(request, PostTestResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        System.out.println("postTestFail400 end");
    }
}
