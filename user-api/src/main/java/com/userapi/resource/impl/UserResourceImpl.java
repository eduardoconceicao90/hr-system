package com.userapi.resource.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapi.domain.User;
import com.userapi.resource.UserResource;
import com.userapi.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResourceImpl implements UserResource {

	@Autowired
	private UserService service;

	@Override
	public ResponseEntity<User> findByid(Long id) {
		return ResponseEntity.ok().body(service.findByid(id));
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
