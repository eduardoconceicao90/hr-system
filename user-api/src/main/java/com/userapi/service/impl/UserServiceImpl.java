package com.userapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.userapi.domain.User;
import com.userapi.repository.UserRepository;
import com.userapi.service.UserService;
import com.userapi.service.exception.ObjectNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private Environment environment;

	@Override
	public User findByid(Long id) {
		log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
