package com.example.pack.enrollment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {

	Enrollment findByPhoneNumber(String phoneNumber);
	
	Enrollment findByEmail(String email);
}
