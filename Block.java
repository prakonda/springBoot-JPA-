package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the block database table.
 * 
 */
@Entity
@NamedQuery(name="Block.findAll", query="SELECT b FROM Block b")
public class Block implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="block_name")
	private String blockName;

	@Column(name="no_of_slots")
	private int noOfSlots;

	//bi-directional many-to-one association to Status
	@ManyToOne  @JoinColumn(name="status_id", referencedColumnName="id")
	private Status status;

	//bi-directional many-to-one association to Lot
	@ManyToOne  @JoinColumn(name="lot_id", referencedColumnName="id")
	private Lot lot;

	//bi-directional many-to-one association to Slot
	@JsonIgnore
	@OneToMany(mappedBy="block",cascade=CascadeType.ALL, targetEntity=Slot.class)
	private List<Slot> slots;

	/**
	 * Block Constructor
	 * 
	 */
	public Block() {
		// Do nothing
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlockName() {
		return this.blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public int getNoOfSlots() {
		return this.noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Lot getLot() {
		return this.lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
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
		slot.setBlock(this);

		return slot;
	}

	/**
     * removeSlot method
     * @param slot
     * @return Slot
     */
	public Slot removeSlot(Slot slot) {
		getSlots().remove(slot);
		slot.setBlock(null);

		return slot;
	}

}