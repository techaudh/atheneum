package com.atheneum.atheneum.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
/*@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class, 
	property = "id"
)*/
public class Author {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	private Integer id;
	
	@Column(name="first_name")
	@Pattern(regexp="^[a-zA-Z ]+$", message = "Author first name should only contain alphabets")
	@NotNull(message = "Author first name should not be null")
	@NotEmpty(message = "Author's first name should not be empty")
	private String firstName;
	
	@Column(name="last_name")
	@Pattern(regexp="^[a-zA-Z ]+$", message = "Author last name should only contain alphabets")
	@NotNull(message = "Author last name should not be null")
	@NotEmpty(message = "Author's last name should not be empty")
	private String lastName;
	
	@Column(name="about", length=1000)
	@NotNull(message = "Author's about should not be null")
	@NotEmpty(message = "Author's about should contain some content")
	private String about;
	
	@Column(name="image")
	@NotNull(message = "Author image should not be null")
	@NotEmpty(message = "Author's image should not be empty")
	private String image;
	
	//@Column(name = "book_id")
	@JsonIgnore
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private Set<Book> books;
	
	public Author(){
		super();
	}

	public Author(Integer id, String firstName, String lastName, String about, String image, Set<Book> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.about = about;
		this.image = image;
		this.books = books;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", about=" + about
				+ ", image=" + image + "]";
	}
}
