package com.example.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.rest.entity.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
ObjectMapper theObjectMapper = new ObjectMapper();
		
		try {
			//File file= new ClassPathResource("/data/input.json").getFile();
			TypeReference<List<Student>> typeRefernce= new TypeReference<List<Student>>() {
			};
			InputStream inputStream=TypeReference.class.getResourceAsStream("/data/input.json");
			System.out.println(inputStream.toString());
			List<Student> theStudent=theObjectMapper.readValue(inputStream, typeRefernce);
			System.out.println(theStudent.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
