package com.example.pack.register;

import static com.example.pack.core.TemplateConstant.ERROR_MESSAGE_NUMERIC_ONLY;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.example.pack.util.FieldsValueMatch;

@SuppressWarnings("serial")
@FieldsValueMatch.List({
		@FieldsValueMatch(field = "password", fieldMatch = "verifyPassword", message = "password fields must match!") })
public class RegisterForm implements Serializable {

	private Integer id;

	@NotBlank
	@Pattern(regexp = "^(?:\\+62|\\(0\\d{2,3}\\)|0)\\s?(?:361|8[17]\\s?\\d?)?(?:[ -]?\\d{3,4}){2,3}$", message = ERROR_MESSAGE_NUMERIC_ONLY)
	private String phoneNumber;

	@NotBlank
	private String username;
	
	@NotBlank
	private String fullName;

	@NotBlank
	private String address;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String verifyPassword;
	
	private String createdBy;
	private String createdTime;
	private String updatedBy;
	private String updatedTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
}
