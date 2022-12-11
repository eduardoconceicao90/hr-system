package com.userapi.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userapi.domain.User;

public interface UserResource {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<User> findByid(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<User>> findAll();

}
