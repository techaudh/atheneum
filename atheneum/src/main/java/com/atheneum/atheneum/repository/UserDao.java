package com.atheneum.atheneum.repository;

import com.atheneum.atheneum.pojo.User;

public interface UserDao{
	public void saveUser(User user) throws Exception;
	public void insertAuthorities(User user) throws Exception;
}