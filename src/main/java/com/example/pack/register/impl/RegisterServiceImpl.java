package com.example.pack.register.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pack.register.RegisterForm;
import com.example.pack.register.RegisterService;

import static com.example.pack.util.UrlConstant.*;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Value("${backend.apps}")
	private String mainUrl;

	@Override
	public RegisterForm saveOrUpdate(RegisterForm entity) {
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterForm> save(RegisterForm request) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(mainUrl + REGISTER_URL, request, RegisterForm.class);
	}

	@Override
	public void delete(RegisterForm entity) {

	}

	@Override
	public void deleteById(String id) {

	}

	@Override
	public RegisterForm findById(String id) {
		return null;
	}

	@Override
	public Long getTotalData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisterForm> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
