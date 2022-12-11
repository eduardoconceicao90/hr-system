package com.userapi.service;

import java.util.List;

import com.userapi.domain.User;

public interface UserService {

	User findByid(Long id);
	List<User> findAll();
	
}