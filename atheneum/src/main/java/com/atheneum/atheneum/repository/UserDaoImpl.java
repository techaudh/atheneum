package com.atheneum.atheneum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atheneum.atheneum.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveUser(User user) {
		jdbcTemplate.update("Insert INTO users (username, password, enabled) VALUES (?, ?, ?)",
				user.getEmail(), user.getPassword(), user.getEnabled());
	}
	
	public void insertAuthorities(User user) {
		jdbcTemplate.update("Insert INTO authorities (username, authority) VALUES (?, ?)",
				user.getEmail(), user.getRole());
	}
}