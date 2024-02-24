package com.i0xnaveen.youtube.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class S3Service implements FileService {
    public static final String BUCKET_NAME = "i0xnaveen-springboot";
    private final AmazonS3 amazonS3Client;

    public String uploadFile(MultipartFile file) throws IOException {
      var fileNameExtension= StringUtils.getFilenameExtension(file.getOriginalFilename());

      var key= UUID.randomUUID().toString()+"."+fileNameExtension; var metadata=new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        amazonS3Client.putObject(BUCKET_NAME,key,file.getInputStream(),metadata);
        amazonS3Client.setObjectAcl(BUCKET_NAME,key, CannedAccessControlList.PublicRead);
        return String.valueOf(amazonS3Client.getUrl(BUCKET_NAME,key));
    }



}
