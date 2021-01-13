package com.example.swagger.request.validator.webclient;

import com.example.swagger.request.validator.webclient.test.response.GetTestResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTestTest extends ApiTest {
    private final String URL = "/test";

    @Test
    public void getTestSuccess() {
        System.out.println("getTestFail200 begin");
        RequestEntity<Void> request = RequestEntity.get(URI.create("/test?query=200"))
            .build();

        ResponseEntity<GetTestResponse> response = context.getRestTemplate().exchange(request, GetTestResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println("getTestFail200 end");
    }

    @Test
    public void getTestFailBecause401Given() {
        System.out.println("getTestFail401 begin");
        RequestEntity<Void> request = RequestEntity.get(URI.create(URL + "?query=401"))
            .build();

        ResponseEntity<GetTestResponse> response = context.getRestTemplate().exchange(request, GetTestResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
        System.out.println("getTestFail401 end");
    }

    @Test
    public void getTestFailBecauseOtherThan401Or200Given() {
        System.out.println("getTestFail400 begin");
        RequestEntity<Void> request = RequestEntity.get(URI.create(URL + "?query=400"))
            .build();

        ResponseEntity<GetTestResponse> response = context.getRestTemplate().exchange(request, GetTestResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        System.out.println("getTestFail400 end");
    }
}
