package com.example.pack.register;

import org.springframework.http.ResponseEntity;

import com.example.pack.core.data.PersistenceService;

public interface RegisterService extends PersistenceService<RegisterForm, String> {

	ResponseEntity<RegisterForm> save(RegisterForm request);
}
