package br.com.lasbr.socialhub.dto;

import br.com.lasbr.socialhub.domain.User;

public record UserDTO(String id, String name, String email) {
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getEmail());
	}
}
