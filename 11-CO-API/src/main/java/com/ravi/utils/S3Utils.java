package com.ravi.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;

@Component
public class S3Utils {

	@Value("${bucketName}")
	private String bucketName;

	private final AmazonS3 s3;

	public S3Utils(AmazonS3 s3) {
		this.s3 = s3;
	}
	
	public String uploadObject(File file) {
		PutObjectResult putObject = s3.putObject(bucketName, file.getName(), file);
		return putObject.getContentMd5();
	}
}
