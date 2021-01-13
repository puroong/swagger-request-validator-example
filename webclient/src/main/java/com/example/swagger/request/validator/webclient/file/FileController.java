package com.example.swagger.request.validator.webclient.file;

import com.example.swagger.request.validator.webclient.file.request.PostFileRequest;
import com.example.swagger.request.validator.webclient.file.response.PostFileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostFileResponse postFile(
        @Valid @RequestPart PostFileRequest postFileRequest
    ) {
        return new PostFileResponse("message");
    }
}
