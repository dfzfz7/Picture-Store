package e3SpringPictureShop.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shop")
public class Shop {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Finds last id value in DB and increments
	private Long id;
	@Column
	private String name;
	@Column
	private int capacity;

	// Entities relationship
	@OneToMany(mappedBy="shop") 
	@JsonIgnore //To fix issue with infinite recursion
	private List<Picture> pictures;

	// CONSTRUCTORES

	public Shop() {
	}

	public Shop(Long id, String name, int capacity) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	
	// METHODS

	// Show shop information
	@Override
	public String toString() {
		return "Shop [id=" + id + ", shop name=" + name + ", storage capacity=" + capacity + "]";
	}

}
