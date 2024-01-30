package br.com.lasbr.socialhub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.dto.UserDTO;
import br.com.lasbr.socialhub.repositories.UserRepository;
import br.com.lasbr.socialhub.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	private final UserRepository repositoy;
	
	public UserService(UserRepository repository) {
		this.repositoy = repository;
	}
	
	public List<User> findAll() {
		return repositoy.findAll();
	}
	
	public User findById(String id) {
		return repositoy.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User obj) {
		return repositoy.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.id(), objDto.name(), objDto.email());
	}
}
