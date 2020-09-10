package e3SpringPictureShop.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "picture")
public class Picture {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Finds last id value in DB and increments
	private Long id;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private Double price;
	@Column(name = "entry_date")
	@Temporal(TemporalType.TIMESTAMP) // Get actual time from system
	private Date date;

	// Entities relationship
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	// CONSTRUCTORES

	public Picture() {
	}

	public Picture(Long id, String title, String author, Double price, Date date) {
		this.id = id;
		this.title = title;
		this.author = addAuthor(author);
		this.price = price;
		this.date = date;
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// METHODS

	// Set author as Anonymous if no author given
	private String addAuthor(String author) {
		if (author == null) {
			author = "Anonimous";
		}
		return author;
	}

	// Picture information
	@Override
	public String toString() {
		return "Picture [id=" + id + ", title= " + title + ", author name=" + author + ", price=" + price
				+ " €, entry date=" + date + "]";
	}

}
