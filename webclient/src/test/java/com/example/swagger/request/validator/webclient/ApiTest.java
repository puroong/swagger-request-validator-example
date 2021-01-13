package com.example.swagger.request.validator.webclient;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {
    @Autowired
    protected ApiTestContext context;

    @BeforeAll
    public static void before() {
        System.out.println("before test");
    }

    @AfterAll
    public static void after() {
        System.out.println("after test");
    }
}
