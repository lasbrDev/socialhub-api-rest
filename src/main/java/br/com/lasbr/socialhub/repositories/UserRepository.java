package br.com.lasbr.socialhub.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lasbr.socialhub.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
