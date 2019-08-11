package com.example.pack.core.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author ariesp
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit implements Serializable {
	private static final long serialVersionUID = 7156908305971687377L;

	public enum Status {
		ACTIVE, NOT_ACTIVE
	}

	@Column(name = "created_by", length = 50)
	@CreatedBy
	private String createdBy;

	@Column(name = "updated_by", length = 50)
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTime;

	@Column(name = "updated_time")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedTime;

	@Enumerated(EnumType.STRING)
	private Status status;

	public String getCreatedBy() {
		return createdBy;
	}

	public Audit setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Audit setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Audit setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public Audit setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public Audit setStatus(Status status) {
		this.status = status;
		return this;
	}
}