package com.nestable.status.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nestable.status.model.UserStatus;

public interface UserStatusRepository extends MongoRepository<UserStatus, String> {

}
