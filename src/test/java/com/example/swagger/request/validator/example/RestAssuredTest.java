package com.example.swagger.request.validator.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


@RunWith(JUnit4.class)
public class RestAssuredTest {
    private static MockMvc mvc;
    private final String specUrl = "swagger-request-validator-test.yaml";

    @BeforeAll
    public static void setup() {
        final TestController testController = new TestController();
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void validateGet() {
        given().mockMvc(mvc)
            .when()
            .get("/test")
            .then()
            .expect(openApi().isValid(specUrl));
    }

    @Test
    public void validatePostWithAllFields() {
        given().mockMvc(mvc)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(new PostRequest("value1"))
            .when()
            .post("/test")
            .then()
            .expect(openApi().isValid("swagger-request-validator-test.yaml"));
    }

    @Test
    public void validatePostWithOnlyRequiredFields() {
        final TestController testController = new TestController();
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
        given().mockMvc(mvc)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(new PostRequest("value1"))
            .when()
            .post("/test")
            .then()
            .expect(openApi().isValid(specUrl));
    }
}
