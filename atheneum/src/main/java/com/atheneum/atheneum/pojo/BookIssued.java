package com.atheneum.atheneum.pojo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="book_issued")
public class BookIssued{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	private int id;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="reader_id")
	private Reader reader;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="book_id")
	private Book book;
	@Column(name="name", length=20)
	@NotNull
	private String name;
	@Column(name="address1", length=100)
	@NotNull
	private String address1;
	@Column(name="address2", length=100)
	private String address2;
	@Column(length=20)
	@Pattern(regexp="[A-Za-z]+$", message="City name should contain only alphabets.")
	@NotNull(message="City should not be null")
	private String city;
	@Column(length=20)
	@Pattern(regexp="[A-Za-z]+$", message="State name should contain only alphabets.")
	@NotNull
	private String state;
	@Column(length=6)
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$", message="Pincode is invalid")
	@NotNull
	private String pincode;
	@Column(name="issue_date")
	@NotNull
	private Date issueDate;
	@Column(name="renewed")
	@NotNull
	@Range(min=0, max=2)
	private Byte renewed;
	
	public BookIssued() {
		
	}
	
	public BookIssued(Reader reader, Book book, @NotNull String name, @NotNull String address1, String address2,
			@Pattern(regexp = "[A-Za-z]+$", message = "City name should contain only alphabets.") @NotNull(message = "City should not be null") String city,
			@Pattern(regexp = "[A-Za-z]+$", message = "State name should contain only alphabets.") @NotNull String state,
			@Pattern(regexp = "^[1-9]{1}[0-9]{5}$", message = "Pincode is invalid") @NotNull String pincode,
			@NotNull Date issueDate, @NotNull @Range(min = 0, max = 2) Byte renewed) {
		super();
		this.reader = reader;
		this.book = book;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.issueDate = issueDate;
		this.renewed = renewed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Byte getRenewed() {
		return renewed;
	}

	public void setRenewed(Byte renewed) {
		this.renewed = renewed;
	}

	@Override
	public String toString() {
		return "BookIssued [id=" + id + ", reader=" + reader + ", book=" + book + ", name=" + name + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", issueDate=" + issueDate + ", renewed=" + renewed + "]";
	}
	
}