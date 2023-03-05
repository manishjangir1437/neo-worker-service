package com.neo.v1.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.neo.core.exception.ServiceException;
import com.neo.v1.reader.PropertyReader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

import static com.neo.v1.enums.WorkerServiceKeyMapping.S3_DELETE_DOCUMENT_ERROR;
import static com.neo.v1.enums.WorkerServiceKeyMapping.S3_GET_DOCUMENT_ERROR;
import static com.neo.v1.enums.WorkerServiceKeyMapping.S3_UPLOAD_DOCUMENT_ERROR;


@Service
@AllArgsConstructor
@Slf4j
public class AwsS3Service {

    private final AmazonS3 amazonS3;
    private final PropertyReader propertyReader;

    public String upload(InputStream file, String fileName, String contentType) {
        try {
            String fileUrlToBeUpload = propertyReader.getAwsS3BaseUrl().concat(fileName);
            log.info("Uploading file {} to S3", fileUrlToBeUpload);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            metadata.setContentLength(file.available());
            AmazonS3URI s3URI = new AmazonS3URI(fileUrlToBeUpload);
            amazonS3.putObject(s3URI.getBucket(), s3URI.getKey(), file, metadata);
            return fileUrlToBeUpload;
        } catch (Exception ex) {
            log.error("Error while uploading file to S3", ex);
            throw new ServiceException(S3_UPLOAD_DOCUMENT_ERROR, ex);
        }
    }

    public void delete(String fileUrlToBeDeleted) {
        try {
            log.info("Deleting file {} from S3", fileUrlToBeDeleted);
            AmazonS3URI s3URI = new AmazonS3URI(fileUrlToBeDeleted);
            amazonS3.deleteObject(s3URI.getBucket(), s3URI.getKey());
        } catch (Exception ex) {
            log.error("Error while deleting file from S3", ex);
            throw new ServiceException(S3_DELETE_DOCUMENT_ERROR, ex);
        }
    }

    public InputStream getS3Data(String url) {
        try {
            log.info("getting file {} from S3", url);
            AmazonS3URI s3URI = new AmazonS3URI(url);
            S3Object s3Object = amazonS3.getObject(s3URI.getBucket(), s3URI.getKey());
            return s3Object.getObjectContent();
        } catch (Exception ex) {
            log.error("Error while getting file to S3", ex);
            throw new ServiceException(S3_GET_DOCUMENT_ERROR, ex);
        }
    }
}
