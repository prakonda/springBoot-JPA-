package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the resource database table.
 * 
 */
@Entity
@Table(name="resource")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String location;

	@Column(name="RESOURCE_IDENTIFICATION_CODE")
	private String resourceIdentificationCode;

	public Resource() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getResourceIdentificationCode() {
		return this.resourceIdentificationCode;
	}

	public void setResourceIdentificationCode(String resourceIdentificationCode) {
		this.resourceIdentificationCode = resourceIdentificationCode;
	}

}