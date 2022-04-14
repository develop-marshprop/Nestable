package com.nestable.otp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nestable.otp.model.Otp;

@Repository
public interface OtpRepository extends MongoRepository<Otp, String>{

}
