package com.example.demo;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.amazonaws.HttpMethod;


import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RequestMapping("/upload")
public class DemoApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(DemoApplication.class, args);
//
////		create s3 client
//		final AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
//		
////		create s3 object
//		S3Object text = s3Client.getObject(source_buckect_name, "mytext.txt");
////		get content of the object
//		S3ObjectInputStream strem = text.getObjectContent();
//		
//		ObjectMapper maper = new ObjectMapper();
//		
//		String content = maper.readValue(strem, Class<T>);
//		
//		System.out.println("content ++++ "+content);
////		List all cucket
//		List<Bucket> buckets = s3Client.listBuckets();
//		
//		buckets.stream().forEach(db ->{
//			System.out.println("bucket name: "+ db.getName());
//		});
//		 Regions clientRegion = Regions.DEFAULT_REGION;
//	        String bucketName = "gayatext0011";
//	        String stringObjKeyName = "uploadimage";
//	        String fileObjKeyName = "accessDoc";
//	        String fileName = "C://Users/Pcadmin//Downloads//dog.jfif";
//
//	        try {
//	            // -----This code expects that you have AWS credentials set up per:
//	            //  ---- https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
//	            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
//	            
//	         // ----- Set the pre-signed URL to expire after one hour.
//	            java.util.Date expiration = new java.util.Date();
//	            long expTimeMillis = expiration.getTime();
//	            expTimeMillis += 1000 * 60 * 60;
//	            expiration.setTime(expTimeMillis);
//	            
//	         // ----- Generate the pre-signed URL.
//	            System.out.println("Generating pre-signed URL.");
//	            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileObjKeyName)
//	                    .withMethod(HttpMethod.PUT)
//	                    .withExpiration(expiration);
//	            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
//	           System.out.println("url : == "+ url);
//	            
//             // ---    Create the connection and use it to upload the new object using the pre-signed URL.========
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setDoOutput(true);
//	            connection.setRequestMethod("PUT");
//	            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//	            out.write("This text uploaded as an object via presigned URL.");
//	            out.close();
//	            
//	            System.out.println("end");
//
//
//	            // ---- Upload a text string as a new object.===========
////	            s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");
//
//	            // Upload a file as a new object with ContentType and title specified. ========
////	            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
////	            s3Client.putObject(request);
//	            
//	            //----- download file
////	            GetObjectRequest request = new GetObjectRequest(bucketName, fileObjKeyName);
////	            S3Object object = s3Client.getObject(request);
////	            S3ObjectInputStream bojectcontent = object.getObjectContent();
////	            IOUtils.copy(bojectcontent, new FileOutputStream("C://Users/Pcadmin//Downloads//downloadDog.jfif"));
//	            
//	        } catch (AmazonServiceException e) {
//	            // The call was transmitted successfully, but Amazon S3 couldn't process 
//	            // it, so it returned an error response.
//	            e.printStackTrace();
//	        } catch (SdkClientException e) {
//	            // Amazon S3 couldn't be contacted for a response, or the client
//	            // couldn't parse the response from Amazon S3.
//	            e.printStackTrace();
//	        }
	}


}
