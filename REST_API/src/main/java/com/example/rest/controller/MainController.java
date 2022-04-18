package com.example.rest.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.rest.entity.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {
	
	
	@GetMapping("/hello")
	public String hello()
	{
		
		ObjectMapper theObjectMapper = new ObjectMapper();
		
		try { 
			//File file= new ClassPathResource("classpath:data/input.json").getFile();
			Student theStudent=theObjectMapper.readValue(new File("src/main/resources/data/input.json"), Student.class);
			return theStudent.toString();
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
		return null;
		  
	}

}
