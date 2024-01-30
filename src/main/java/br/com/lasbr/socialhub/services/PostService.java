package br.com.lasbr.socialhub.services;

import org.springframework.stereotype.Service;

import br.com.lasbr.socialhub.domain.Post;
import br.com.lasbr.socialhub.repositories.PostRepository;
import br.com.lasbr.socialhub.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	private final PostRepository repository;
	
	public PostService(PostRepository repository) {
		this.repository = repository;
	}

	public Post findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
