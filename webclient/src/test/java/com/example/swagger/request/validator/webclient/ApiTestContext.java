package com.example.swagger.request.validator.webclient;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.report.LevelResolver;
import com.atlassian.oai.validator.report.ValidationReport;
import com.atlassian.oai.validator.springweb.client.OpenApiValidationClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;

@Component
public class ApiTestContext {
    private TestRestTemplate testRestTemplate;

    private OpenApiValidationClientHttpRequestInterceptor validationInterceptor = new OpenApiValidationClientHttpRequestInterceptor(
        OpenApiInteractionValidator.createForSpecificationUrl("spec.yaml")
        .withLevelResolver(
            LevelResolver.create().withLevel("validation.request", ValidationReport.Level.IGNORE).build()
        )
        .build()
    );

    @Autowired
    public ApiTestContext(ServletWebServerApplicationContext webServerAppCtxt) {
        final int port = webServerAppCtxt.getWebServer().getPort();
        final String rootUri = "http://localhost:"+port;

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
            .interceptors(Collections.singletonList(validationInterceptor))
            .uriTemplateHandler(new DefaultUriBuilderFactory(rootUri))
            .rootUri(rootUri);

        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    public TestRestTemplate getRestTemplate() {
        return testRestTemplate;
    }
}
