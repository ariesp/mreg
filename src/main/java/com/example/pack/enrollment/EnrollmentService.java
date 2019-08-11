package com.example.pack.enrollment;

import com.example.pack.core.data.PersistenceService;

public interface EnrollmentService extends PersistenceService<Enrollment, String> {

	Enrollment findByPhoneNumber(String phoneNumber);
	
	Enrollment findByEmail(String email);
	
}
