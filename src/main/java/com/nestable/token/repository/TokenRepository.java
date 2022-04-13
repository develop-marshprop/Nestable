package com.nestable.token.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nestable.token.model.Token;

@Repository
public interface TokenRepository extends MongoRepository<Token, String>{

}
