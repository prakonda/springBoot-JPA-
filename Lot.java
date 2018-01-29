package com.parking.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the lot database table.
 * 
 */
@Entity
@NamedQuery(name="Lot.findAll", query="SELECT l FROM Lot l")
public class Lot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String address;

	private BigDecimal latitude;

	private BigDecimal longitude;

	@Column(name="lot_name")
	private String lotName;

	@Column(name="no_of_blocks")
	private int noOfBlocks;

	private int radius;

	//bi-directional many-to-one association to Block
	@JsonIgnore
	@OneToMany(mappedBy="lot",cascade=CascadeType.ALL, targetEntity=Block.class)
	private List<Block> blocks;

	//bi-directional many-to-one association to Status
	@ManyToOne @JoinColumn(name="status_id", referencedColumnName="id")
	private Status status;

	/**
     * Lot Constructor
     */
	public Lot() {
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

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getLotName() {
		return this.lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public int getNoOfBlocks() {
		return this.noOfBlocks;
	}

	public void setNoOfBlocks(int noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		block.setLot(this);

		return block;
	}

	/**
     * removeBlock method
     * @param block
     * @return Block
     */
	public Block removeBlock(Block block) {
		getBlocks().remove(block);
		block.setLot(null);

		return block;
	}

}