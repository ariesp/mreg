package com.example.pack.enrollment;

import static com.example.pack.core.TemplateConstant.ERROR_MESSAGE_NUMERIC_ONLY;
import static com.example.pack.util.FormatHelper.parseDate;

import java.io.Serializable;
import java.text.ParseException;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.example.pack.enrollment.Enrollment.Gender;

@SuppressWarnings("serial")
public class EnrollmentForm implements Serializable {

	private String id;

	@NotBlank
	@Pattern(regexp = "^(?:\\+62|\\(0\\d{2,3}\\)|0)\\s?(?:361|8[17]\\s?\\d?)?(?:[ -]?\\d{3,4}){2,3}$", message = ERROR_MESSAGE_NUMERIC_ONLY)
	private String phoneNumber;

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	private String birthDate;
	
	private String gender;
	
	public Enrollment bindToModel(Enrollment enrollment) throws ParseException {
		enrollment
			.setId(this.id)
			.setEmail(this.email.toLowerCase())
			.setFirstName(WordUtils.capitalizeFully(this.firstName))
			.setGender(StringUtils.isNotBlank(this.gender) ? Gender.valueOf(this.gender) : null)
			.setLastName(WordUtils.capitalizeFully(this.lastName))
			.setPhoneNumber(this.phoneNumber)
			.setBirthDate(StringUtils.isNotBlank(this.birthDate) ? parseDate(this.birthDate) : null);
		return enrollment;
	}

	public String getId() {
		return id;
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

	public String getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
