package com.example.swagger.request.validator.webclient;

import com.example.swagger.request.validator.webclient.file.request.PostFileRequest;
import com.example.swagger.request.validator.webclient.file.response.PostFileResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostFileTest extends ApiTest {
    private String url = "/file";

    @Test
    public void postFileSuccess() {
        RequestEntity<PostFileRequest> request = RequestEntity.post(URI.create(url))
            .body(new PostFileRequest(new MockMultipartFile("temp.tmp", "Hello World".getBytes())));

        ResponseEntity<PostFileResponse> response = context.getRestTemplate().exchange(request, PostFileResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }
}
