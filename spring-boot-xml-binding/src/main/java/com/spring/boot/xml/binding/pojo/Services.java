package com.spring.boot.xml.binding.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "services")
@AllArgsConstructor
@NoArgsConstructor
public class Services {
	
	private String name;
	
	private List<Service> service;

	@XmlAttribute(name = "name",required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "service")
	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}
	
	

}
