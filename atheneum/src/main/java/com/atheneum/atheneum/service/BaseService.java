package com.atheneum.atheneum.service;

import com.atheneum.atheneum.pojo.Reader;

public interface BaseService{
	public Reader registerReader(Reader reader);
	public Reader getReader(String email);
}