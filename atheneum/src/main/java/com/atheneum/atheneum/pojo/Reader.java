package com.atheneum.atheneum.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reader")
public class Reader {
	@Id
	@Column(name="reader_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="first_name", length=20)
	@Size(max=20)
	@NotNull(message="First Name is required")
	private String firstName;
	@Column(name="last_name", length=20)
	@Size(max=20)
	@NotNull
	private String lastName;
	@Column
	@NotNull
	private Character gender;
	@Column(unique=true, length=50)
	@NotNull(message="Email is required")
	@Email(message="Email should be valid")
	private String email;
	@Transient
	private String password;
	@Column(name="mobile_no", unique=true, length=13)
	@NotNull
	@Size(max=13)
	private String mobileNo;
	@Column(name="image", length=100)
	private String image;
	@Column(length=100)
	private String address1;
	@Column(length=100)
	private String address2;
	@Column(length=20)
	@Pattern(regexp="[A-Za-z]+$", message="City name should contain only alphabets.")
	private String city;
	@Column(length=20)
	@Pattern(regexp="[A-Za-z]+$", message="State name should contain only alphabets.")
	private String state;
	@Column(length=6)
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$", message="Pincode is invalid")
	private String pincode;
	@JsonIgnore
	@OneToMany(mappedBy="reader",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private Set<BookIssued> booksIssued;
	
	private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Reader() {
		super();
	}
	
	public Reader(Integer id, String firstName, String lastName, Character gender, String email, String password,
			String mobileNo, String image, String address1, String address2, String city, String state,
			String pincode, Set<BookIssued> booksIssued) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.image = image;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.booksIssued = booksIssued;
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

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != null) {
			this.password = passwordEncoder.encode(password);
		}else {
			this.password = null;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String contactNo) {
		this.mobileNo = contactNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Set<BookIssued> getBooksIssued() {
		return booksIssued;
	}

	public void addBookIssued(BookIssued bookIssued) {
		if(this.booksIssued == null) {
			this.booksIssued = new HashSet<BookIssued>();
		}
		this.booksIssued.add(bookIssued);
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo + ", image=" + image
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", booksIssued=" + booksIssued + "]";
	}
}
