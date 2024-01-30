package br.com.lasbr.socialhub.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lasbr.socialhub.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
