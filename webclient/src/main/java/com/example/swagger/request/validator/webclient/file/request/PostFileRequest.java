package com.example.swagger.request.validator.webclient.file.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
public class PostFileRequest {
    private MultipartFile file;
}
