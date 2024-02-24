package com.i0xnaveen.youtube.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public interface FileService {
    String uploadFile(MultipartFile file) throws IOException;
}
