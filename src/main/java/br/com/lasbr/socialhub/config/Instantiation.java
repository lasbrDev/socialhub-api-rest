package br.com.lasbr.socialhub.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	private final UserRepository repository;
	
	public Instantiation(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
