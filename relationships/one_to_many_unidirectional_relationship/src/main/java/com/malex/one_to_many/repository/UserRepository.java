package com.malex.one_to_many.repository;

import com.malex.one_to_many.repository.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {}
