package com.educandoweb.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.dto.AuthorDTO;
import com.educandoweb.workshopmongo.repository.PostRepository;
import com.educandoweb.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User marcelo = new User(null, "Marcelo Fuhr", "marcelo@gmail.com");
		User dayane = new User(null, "Dayane Oenning", "dayane@icloud.com");
		User rodrigo = new User(null, "Rodrigo Cristo", "rodrigo@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(marcelo, dayane, rodrigo));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(marcelo));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje.", new AuthorDTO(marcelo));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		marcelo.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(marcelo);
		
	}

}
