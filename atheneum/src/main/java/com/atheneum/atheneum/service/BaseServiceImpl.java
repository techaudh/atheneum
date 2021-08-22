package com.atheneum.atheneum.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.atheneum.atheneum.pojo.Reader;
import com.atheneum.atheneum.pojo.User;
import com.atheneum.atheneum.repository.ReaderRepository;
import com.atheneum.atheneum.repository.UserDao;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private ReaderRepository readerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public Reader registerReader(Reader reader){
		User user = new User(reader.getEmail(), reader.getPassword(), "ROLE_READER", 1);
		try {
			userDao.saveUser(user);
			userDao.insertAuthorities(user);
			reader = readerDao.saveAndFlush(reader);
			return reader;
		}catch(DuplicateKeyException e) {
			throw new RuntimeException("Email already exists!");
		}catch(Exception e) {
			System.out.println("Exception in BaseService:");
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public Reader getReader(String email) {
		return readerDao.findByEmail(email);
	}
}