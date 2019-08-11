package com.example.pack.core.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class Persistence extends Audit {
	private static final long serialVersionUID = 5545587626592882993L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", unique = true)
	private String id;

	public String getId() {
		return id;
	}

	public Persistence setId(String id) {
		this.id = id;
		return this;
	}
}