package com.userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.userapi.domain.User;
import com.userapi.repository.UserRepository;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Eduardo", "eduardo@mail.com", "123", 20.0),
				new User(null, "Telma", "telma@mail.com", "123", 30.0)
			));			
	}

}
