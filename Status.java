package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="status_code")
	private String statusCode;

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to Block
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL, targetEntity=Block.class)
	@JsonIgnore
	private List<Block> blocks;

	//bi-directional many-to-one association to Bookingdetail
	@JsonIgnore
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL, targetEntity=Bookingdetail.class)
	@JsonIgnoreProperties(value = "bookingdetails")
	private List<Bookingdetail> bookingdetails;

	//bi-directional many-to-one association to Lot
	@JsonIgnore
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL, targetEntity=Lot.class)
	private List<Lot> lots;

	//bi-directional many-to-one association to Slot
	@JsonIgnore
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL, targetEntity=Slot.class)
	private List<Slot> slots;

	/**
	 * Status Constructor
	 * 
	 */
	public Status() {
		// Do nothing
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Block> getBlocks() {
		return this.blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	/**
	 * addBlock method 
	 * @param block
	 * @return Block
	 */
	public Block addBlock(Block block) {
		getBlocks().add(block);
		block.setStatus(this);

		return block;
	}

	/**
     * removeBlock method
     * @param block
     * @return Block
     */
	public Block removeBlock(Block block) {
		getBlocks().remove(block);
		block.setStatus(null);

		return block;
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
		bookingdetail.setStatus(this);

		return bookingdetail;
	}

	/**
     * removeBookingdetail method
     * @param bookingdetail
     * @return Bookingdetail
     */
	public Bookingdetail removeBookingdetail(Bookingdetail bookingdetail) {
		getBookingdetails().remove(bookingdetail);
		bookingdetail.setStatus(null);

		return bookingdetail;
	}

	public List<Lot> getLots() {
		return this.lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	/**
     * addLot method
     * @param lot
     * @return Lot
     */
	public Lot addLot(Lot lot) {
		getLots().add(lot);
		lot.setStatus(this);

		return lot;
	}

	/**
     * removeLot method
     * @param lot
     * @return Lot
     */
	public Lot removeLot(Lot lot) {
		getLots().remove(lot);
		lot.setStatus(null);

		return lot;
	}

	public List<Slot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	/**
     * addSlot method
     * @param slot
     * @return Slot
     */
	public Slot addSlot(Slot slot) {
		getSlots().add(slot);
		slot.setStatus(this);

		return slot;
	}

	/**
     * removeSlot method
     * @param slot
     * @return Slot
     */
	public Slot removeSlot(Slot slot) {
		getSlots().remove(slot);
		slot.setStatus(null);

		return slot;
	}

}