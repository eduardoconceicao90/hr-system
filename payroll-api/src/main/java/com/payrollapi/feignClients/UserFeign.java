package com.payrollapi.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payrollapi.domain.User;

@FeignClient(name = "user-api")
public interface UserFeign {
	
	@GetMapping(value = "users/{id}")
	ResponseEntity<User> findByid(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<User>> findAll();
}
