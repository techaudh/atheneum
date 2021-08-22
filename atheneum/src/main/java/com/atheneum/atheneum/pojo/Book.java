package com.atheneum.atheneum.pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
/*@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class, 
	property = "book_id"
)*/
public class Book{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer id;
	
	@Column(name = "name")
	@NotNull(message = "Book name should not be null")
	@NotEmpty(message = "Book name should not be empty")
	private String name;
	
	@Column(name = "category")
	@Pattern(regexp="^[a-zA-Z]+$")
	@NotNull(message = "Book category should not be null")
	@NotEmpty(message = "Book must have some category")
	private String category;
	
	@Column(name = "price")
	@NotNull(message = "Book price should not be null")
	@Positive(message = "Book's price should should be positive number")
	private Integer price;
	
	@Column(name = "preface", length=1000)
	@NotNull(message = "Book should have a preface")
	@NotEmpty(message = "Book should have a preface")
	private String preface;
	
	@Column(name = "quantity")
	@NotNull(message = "Book quantity should not be null")
	@PositiveOrZero(message = "Book's quantity should be positive or zero")
	private Integer quantity;
	
	@Column(name = "front_image")
	@NotNull(message = "Book front image should not be null")
	@NotEmpty(message = "Book front image should not be empty")
	private String frontImage;
	
	@Column(name = "back_image")
	private String backImage;
	
	@Column(name = "reviews")
	@DecimalMax(value = "5")
	@DecimalMin(value = "0")
	private BigDecimal reviews;
	
	@JoinColumn(name = "author_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;
	
	@JsonIgnore
	@OneToMany(mappedBy="book", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private Set<BookIssued> booksIssued;
	
	public Book(){
		super();
	}

	public Book(Integer id, String name, Author author, String category, Integer price, String preface,
			Integer quantity, String frontImage, String backImage, BigDecimal reviews, Set<BookIssued> booksIssued) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.preface = preface;
		this.quantity = quantity;
		this.frontImage = frontImage;
		this.backImage = backImage;
		this.reviews = reviews;
		this.booksIssued = booksIssued;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPreface() {
		return preface;
	}

	public void setPreface(String preface) {
		this.preface = preface;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(String frontImage) {
		this.frontImage = frontImage;
	}

	public String getBackImage() {
		return backImage;
	}

	public void setBackImage(String backImage) {
		this.backImage = backImage;
	}

	public BigDecimal getReviews() {
		return reviews;
	}

	public void setReviews(BigDecimal reviews) {
		this.reviews = reviews;
	}

	public Set<BookIssued> getBooksIssued() {
		return booksIssued;
	}

	public void addBookIssued(BookIssued bookIssued) {
		if(this.booksIssued == null)
			this.booksIssued = new HashSet<BookIssued>();
		this.booksIssued.add(bookIssued);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", preface="
				+ preface + ", quantity=" + quantity + ", frontImage=" + frontImage + ", backImage=" + backImage
				+ ", reviews=" + reviews + ", author=" + author + ", booksIssued=" + booksIssued + "]";
	}
}