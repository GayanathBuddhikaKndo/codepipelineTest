package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@RestController
@RequestMapping("/upload")
public class upload {
	
	 @PostMapping("/image")
	  public String uploadImage(@RequestParam("imageFile") MultipartFile file) {
		  String url = "";
		  
		  try {
			File imageFile = convert(file);
			String filename = file.getOriginalFilename();
			url = "https://gayatext0011.s3.us-east-2.amazonaws.com/"+filename;
			uploadtoS3bucket(filename, imageFile);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return url;
	  }
	  
	  private File convert(MultipartFile file) throws IOException {
			File convFile = new File(file.getOriginalFilename());
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			return convFile;
	  }
	  
	  private void uploadtoS3bucket(String filename,File file) {
		  Regions clientRegion = Regions.US_EAST_2;
		 
         // create client
//		  AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
		    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();
		  s3Client.putObject("gayatext0011", filename, file);
//		    s3Client.putObject(new PutObjectRequest("content-upload-dev", filename, file)
//	                .withCannedAcl(CannedAccessControlList.PublicRead));
	  }
	  

}
