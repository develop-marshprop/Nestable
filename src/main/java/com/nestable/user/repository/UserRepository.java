package com.nestable.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nestable.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
