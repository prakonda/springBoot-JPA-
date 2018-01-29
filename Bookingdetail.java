package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the bookingdetails database table.
 * 
 */
@Entity
@Table(name="bookingdetails")
@NamedQuery(name="Bookingdetail.findAll", query="SELECT b FROM Bookingdetail b")
public class Bookingdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_intime")
	private Date actualIntime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_outtime")
	private Date actualOuttime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reserved_on")
	private Date reservedOn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reserved_until")
	private Date reservedUntil;

	@Basic(optional = false)
	@Column(name="used_hrs", nullable = false)
	private int usedHrs;

	@Basic(optional = false)
	@Column(name="used_mins", nullable = false)
	private int usedMins;
	
	//@JsonIgnore
	//bi-directional many-to-one association to Slot
	@ManyToOne  @JoinColumn(name="slot_id", referencedColumnName="id")
	@JsonIgnoreProperties(value = "slot")
	private Slot slot;

	//bi-directional many-to-one association to Status
	@ManyToOne  @JoinColumn(name="status_id", referencedColumnName="id")
	@JsonIgnoreProperties(value = "status")
	private Status status;

	//bi-directional many-to-one association to Customer
	@ManyToOne  @JoinColumn(name="user_id", referencedColumnName="id")
	@JsonIgnoreProperties(value = "customer")
	private Customer customer;

	/**
     * Bookingdetail Constructor
     */
	public Bookingdetail() {
		// Do nothing
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActualIntime() {
		return this.actualIntime;
	}

	public void setActualIntime(Date actualIntime) {
		this.actualIntime = actualIntime;
	}

	public Date getActualOuttime() {
		return this.actualOuttime;
	}

	public void setActualOuttime(Date actualOuttime) {
		this.actualOuttime = actualOuttime;
	}

	public Date getReservedOn() {
		return this.reservedOn;
	}

	public void setReservedOn(Date reservedOn) {
		this.reservedOn = reservedOn;
	}

	public Date getReservedUntil() {
		return this.reservedUntil;
	}

	public void setReservedUntil(Date reservedUntil) {
		this.reservedUntil = reservedUntil;
	}

	public int getUsedHrs() {
		return this.usedHrs;
	}

	public void setUsedHrs(int usedHrs) {
		this.usedHrs = usedHrs;
	}

	public int getUsedMins() {
		return this.usedMins;
	}

	public void setUsedMins(int usedMins) {
		this.usedMins = usedMins;
	}

	public Slot getSlot() {
		return this.slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}