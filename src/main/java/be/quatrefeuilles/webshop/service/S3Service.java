package be.quatrefeuilles.webshop.service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class S3Service {

    private static final String BUCKET_NAME = "fbrcls";

    public void uploadFile(InputStream is, String fileName) throws Exception {
        AmazonS3 amazonS3Client = AmazonS3Client.builder()
                .withCredentials(new ProfileCredentialsProvider())
                .build();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(is.available());
        amazonS3Client.putObject(new PutObjectRequest(BUCKET_NAME, fileName, is, objectMetadata));
    }

}
