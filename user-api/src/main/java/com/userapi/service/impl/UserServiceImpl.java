package com.userapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapi.domain.User;
import com.userapi.repository.UserRepository;
import com.userapi.service.UserService;
import com.userapi.service.exception.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User findByid(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
