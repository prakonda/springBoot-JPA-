package com.parking.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the slot database table.
 * 
 */
@Entity
@NamedQuery(name="Slot.findAll", query="SELECT s FROM Slot s")
public class Slot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="is_for_disabled")
	private byte isForDisabled;

	@Column(name="is_for_women")
	private byte isForWomen;

	@Column(name="length_in_feets")
	private int lengthInFeets;

	@Column(name="slot_code")
	private String slotCode;

	//bi-directional many-to-one association to Bookingdetail
	@OneToMany(mappedBy="slot",cascade=CascadeType.ALL, targetEntity=Bookingdetail.class)
	@JsonIgnoreProperties(value = "Bookingdetail") 
	@JsonBackReference
	private List<Bookingdetail> bookingdetails;

	//bi-directional many-to-one association to Block
	//@JsonIgnore
	@ManyToOne @JoinColumn(name="block_id", referencedColumnName="id")
	private Block block;

	//bi-directional many-to-one association to Status
	@ManyToOne @JoinColumn(name="status_id", referencedColumnName="id")
	private Status status;

	/**
     * Slot Constructor
     */
	public Slot() {
		// Do nothing
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsForDisabled() {
		return this.isForDisabled;
	}

	public void setIsForDisabled(byte isForDisabled) {
		this.isForDisabled = isForDisabled;
	}

	public byte getIsForWomen() {
		return this.isForWomen;
	}

	public void setIsForWomen(byte isForWomen) {
		this.isForWomen = isForWomen;
	}

	public int getLengthInFeets() {
		return this.lengthInFeets;
	}

	public void setLengthInFeets(int lengthInFeets) {
		this.lengthInFeets = lengthInFeets;
	}

	public String getSlotCode() {
		return this.slotCode;
	}

	public void setSlotCode(String slotCode) {
		this.slotCode = slotCode;
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
		bookingdetail.setSlot(this);

		return bookingdetail;
	}

	/**
     * removeBookingdetail method
     * @param bookingdetail
     * @return Bookingdetail
     * 
     */
	public Bookingdetail removeBookingdetail(Bookingdetail bookingdetail) {
		getBookingdetails().remove(bookingdetail);
		bookingdetail.setSlot(null);

		return bookingdetail;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}