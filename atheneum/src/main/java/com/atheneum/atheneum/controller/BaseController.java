package com.atheneum.atheneum.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atheneum.atheneum.pojo.Reader;
import com.atheneum.atheneum.service.BaseService;

@RestController
@RequestMapping("/")
public class BaseController{
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/login")
	@SuppressWarnings("unchecked")
	public Map<String, Object> user(Principal user){
		Collection<SimpleGrantedAuthority> authorities = 
				(Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role = authorities.toArray()[0].toString();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("user", user);
		Reader reader = null;
		if(role.compareTo("ROLE_READER") == 0) {
			reader = baseService.getReader(user.getName());
			response.put("reader", reader);
		}
		return response;
	}
	
	@PostMapping("/registerReader")
	@Transactional
	public Reader registerUser(@RequestBody @Valid Reader reader) {
		System.out.println(reader);
		reader = baseService.registerReader(reader);
		if(reader == null) {
			throw new RuntimeException("Unable to register user. Check server logs for an issue!");
		}
		return reader;
	}
}