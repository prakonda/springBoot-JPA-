package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private String city;

	@Column(name="mobile_num")
	private String mobileNum;

	private String name;

	private String email;

	private String pincode;

	@Column(name="vehicle_num")
	private String vehicleNum;
	
	@JsonIgnore
	//bi-directional many-to-one association to Bookingdetail
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL, targetEntity=Bookingdetail.class)
	@JsonIgnoreProperties(value = "bookingdetails")
	private List<Bookingdetail> bookingdetails;

	/**
     * Customer Constructor
     */
	public Customer() {
		// Do nothing
	}

	public int getId() {
		
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileNum() {
		return this.mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public List<Bookingdetail> getBookingdetails() {
		return this.bookingdetails;
	}

	public void setBookingdetails(List<Bookingdetail> bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	/**
     * addBookingdetail method
     * @param bookingdetail
     * @return Bookingdetail
     */
	public Bookingdetail addBookingdetail(Bookingdetail bookingdetail) {
		getBookingdetails().add(bookingdetail);
		bookingdetail.setCustomer(this);

		return bookingdetail;
	}

	/**
     * removeBookingdetail method
     * @param bookingdetail
     * @return Bookingdetail
     */
	public Bookingdetail removeBookingdetail(Bookingdetail bookingdetail) {
		getBookingdetails().remove(bookingdetail);
		bookingdetail.setCustomer(null);

		return bookingdetail;
	}

	
}