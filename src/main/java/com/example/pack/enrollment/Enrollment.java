package com.example.pack.enrollment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.pack.core.data.Persistence;

/**
 * @author ariesp
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "mreg_enrollment")
public class Enrollment extends Persistence {
	
	public enum Gender {
		MALE, FEMALE
	}

	@NotNull
	@Column(length = 30, name = "phone_number", unique = true)
	private String phoneNumber;

	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Column(length = 100, unique = true)
	private String email;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Override
	public Enrollment setId(String id) {
		super.setId(id);
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public Enrollment setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Enrollment setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Enrollment setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Enrollment setEmail(String email) {
		this.email = email;
		return this;
	}

	public Enrollment setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Enrollment setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	@Override
	public String toString() {
		return "Enrollment "
				+ "["
				+ "phoneNumber=" + phoneNumber + ", "
				+ "firstName=" + firstName + ", "
				+ "lastName=" + lastName + ", "
				+ "email=" + email + ", "
				+ "birthDate=" + birthDate + ", "
				+ "gender=" + gender + ", "
				+ "id=" + getId() + "]";
	}
	
}
