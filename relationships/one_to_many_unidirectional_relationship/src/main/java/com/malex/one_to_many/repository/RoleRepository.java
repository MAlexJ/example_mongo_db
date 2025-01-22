package com.malex.one_to_many.repository;

import com.malex.one_to_many.repository.entity.RoleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<RoleEntity, String> {}
