package br.com.lasbr.socialhub.dto;

import br.com.lasbr.socialhub.domain.User;

public record AuthorDTO(String id, String name) {

	public AuthorDTO(User user) {
		this(user.getId(), user.getName());
	}
}
