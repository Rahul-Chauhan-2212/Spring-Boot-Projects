package com.spring.boot.xml.binding;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.xml.binding.pojo.Service;
import com.spring.boot.xml.binding.pojo.Services;

@SpringBootApplication
public class SpringBootXmlBindingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootXmlBindingApplication.class, args);
	    try {
			JAXBContext contextObj = JAXBContext.newInstance(Services.class);
			 Marshaller marshallerObj = contextObj.createMarshaller();  
			   marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
			   Services services = new Services("rahul",Arrays.asList(new Service("url1","crm","header1"),new Service("url2","clos","header2")) );
			    try {
					marshallerObj.marshal(services, new FileOutputStream("services.xml"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}
