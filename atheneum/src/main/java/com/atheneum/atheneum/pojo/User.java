package com.atheneum.atheneum.pojo;

public class User{
	private Integer id;
	private String email;
	private String password;
	private String role;
	private Integer enabled;
	
	public User() {
		
	}

	public User(String email, String password, String role, Integer enabled) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", enabled="
				+ enabled + "]";
	}
}