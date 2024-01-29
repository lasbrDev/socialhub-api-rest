package br.com.lasbr.socialhub.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	private final UserService service;
	
	public UserResource(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
