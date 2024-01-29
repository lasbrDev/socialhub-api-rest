package br.com.lasbr.socialhub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lasbr.socialhub.domain.User;
import br.com.lasbr.socialhub.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository repositoy;
	
	public UserService(UserRepository repository) {
		this.repositoy = repository;
	}
	
	public List<User> findAll() {
		return repositoy.findAll();
	}
}
