package com.example.pack.enrollment.impl;

import static com.example.pack.core.data.Audit.Status.ACTIVE;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pack.enrollment.Enrollment;
import com.example.pack.enrollment.EnrollmentRepository;
import com.example.pack.enrollment.EnrollmentService;

@Service
@Transactional(readOnly = true)
public class EnrollmentServiceImpl implements EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Enrollment saveOrUpdate(Enrollment entity) {
		Enrollment enrollment;
		if (StringUtils.isNotBlank(entity.getId())) {
			enrollment = enrollmentRepository.findOne(entity.getId());
		} else {
			enrollment = entity;
			enrollment.setStatus(ACTIVE);
		}
		return enrollmentRepository.save(enrollment);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Enrollment entity) {
		enrollmentRepository.delete(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteById(String id) {
		enrollmentRepository.delete(id);
	}

	@Override
	public Enrollment findById(String id) {
		return enrollmentRepository.findOne(id);
	}

	@Override
	public Long getTotalData() {
		return enrollmentRepository.count();
	}

	@Override
	public Enrollment findByPhoneNumber(String phoneNumber) {
		return enrollmentRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Enrollment findByEmail(String email) {
		return enrollmentRepository.findByEmail(email);
	}

	@Override
	public List<Enrollment> getAll() {
		return enrollmentRepository.findAll();
	}
	
}
