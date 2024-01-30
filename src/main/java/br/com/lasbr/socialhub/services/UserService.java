package br.com.lasbr.socialhub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.dto.UserDTO;
import br.com.lasbr.socialhub.repositories.UserRepository;
import br.com.lasbr.socialhub.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newUser = repository.findById(obj.getId())
				.orElseThrow(() -> new ObjectNotFoundException("User not found"));
		updateData(newUser, obj);
		return repository.save(newUser);
	}
	
	private void updateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.id(), objDto.name(), objDto.email());
	}
}
