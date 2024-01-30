package br.com.lasbr.socialhub.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lasbr.socialhub.domain.Post;
import br.com.lasbr.socialhub.resources.util.URL;
import br.com.lasbr.socialhub.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResources {

	private final PostService service;
	
	public PostResources(PostService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value= "text", defaultValue= "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
