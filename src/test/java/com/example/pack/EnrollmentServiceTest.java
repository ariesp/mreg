package com.example.pack;

import static com.example.pack.enrollment.Enrollment.Gender.MALE;
import static com.example.pack.util.FormatHelper.parseDate;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.pack.enrollment.Enrollment;
import com.example.pack.enrollment.EnrollmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollmentServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(EnrollmentServiceTest.class);

	@Autowired
	private EnrollmentService enrollmentService;
	
	@Test
	@Order(1)
	public void testSaveData() throws ParseException {
		Enrollment enrollment = new Enrollment();
		enrollment.setBirthDate(parseDate("2-4-1998"));
		enrollment.setEmail("ariezprayoga@gmail.com");
		enrollment.setFirstName("aries");
		enrollment.setGender(MALE);
		enrollment.setLastName("prayuga");
		enrollment.setPhoneNumber("081234567890");
		enrollmentService.saveOrUpdate(enrollment);
		
		Assert.assertNotNull(enrollment.getId());
		LOG.debug("enrollment data saved: {}", enrollment.toString());
	}
	
	@Test
	@Order(2)
	public void testDeleteData() {
		Enrollment enrollment1 = enrollmentService.findByEmail("ariezprayoga@gmail.com");
		LOG.debug("deleting enrollment data with email: {}", enrollment1.getEmail());
		enrollmentService.delete(enrollment1);
		
		Enrollment enrollment2 = enrollmentService.findByEmail("ariezprayoga@gmail.com");
		Assert.assertNull(enrollment2);
	}
}
