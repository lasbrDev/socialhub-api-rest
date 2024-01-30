package br.com.lasbr.socialhub.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.lasbr.socialhub.domain.Post;
import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.dto.AuthorDTO;
import br.com.lasbr.socialhub.dto.CommentDTO;
import br.com.lasbr.socialhub.repositories.PostRepository;
import br.com.lasbr.socialhub.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	private final UserRepository userRepository;
	
	private final PostRepository postRepository;
	
	public Instantiation(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User johane = new User(null, "Johane Doe", "johane@gmail.com");
		User john = new User(null, "John Doe", "john@gmail.com");
		User peter = new User(null, "Peter Pettigrew", "peter@gmail.com");
		
		userRepository.saveAll(Arrays.asList(johane, john, peter));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(johane));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(johane));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem, Maria!", sdf.parse("21/03/2018"), new AuthorDTO(john));
		CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(peter));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(john));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		johane.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(johane);
	}
}
