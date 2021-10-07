package com.service.layer.Helper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTempleteHelper {

	
	private RestTemplate restTemplate;
	private ObjectMapper objectmapper;
	
	
	@Autowired
	public RestTempleteHelper(RestTemplateBuilder builder,ObjectMapper mapper) {
		this.restTemplate = builder.build();
		this.objectmapper = mapper;
	}
	
	public <T> T getForEntiry(Class<T> clazz,String url,Object... objects) {
		
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, objects);
			JavaType javaTYpe = objectmapper.getTypeFactory().constructType(clazz);
			return readValue(response,javaTYpe);
		}
		catch(HttpClientErrorException exception) {
			exception.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private <T> T readValue(ResponseEntity<String> response,JavaType javaType) {
		T result =null;
		if(response.getStatusCode() == HttpStatus.OK || response.getStatusCode()==HttpStatus.CREATED) {
			try {
				result = objectmapper.readValue(response.getBody(),javaType);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
