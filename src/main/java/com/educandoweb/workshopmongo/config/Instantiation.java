package com.educandoweb.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User marcelo = new User(null, "Marcelo Fuhr", "marcelo@gmail.com");
		User dayane = new User(null, "Dayane Oenning", "dayane@icloud.com");
		User rodrigo = new User(null, "Rodrigo Cristo", "rodrigo@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(marcelo, dayane, rodrigo));
		
	}

}
