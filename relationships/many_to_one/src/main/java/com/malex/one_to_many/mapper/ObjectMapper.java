package com.malex.one_to_many.mapper;

import com.malex.one_to_many.controller.dto.RoleRequest;
import com.malex.one_to_many.controller.dto.RoleResponse;
import com.malex.one_to_many.controller.dto.UserRequest;
import com.malex.one_to_many.controller.dto.UserResponse;
import com.malex.one_to_many.repository.entity.RoleEntity;
import com.malex.one_to_many.repository.entity.UserEntity;
import org.mapstruct.Mapper;

/** MapStruct mapper: */
@Mapper(componentModel = "spring")
public interface ObjectMapper {

  UserResponse entityToDto(UserEntity entity);

  RoleResponse entityToDto(RoleEntity entity);

  RoleEntity dtoToEntity(RoleRequest dto);

  UserEntity dtoToEntity(UserRequest dto);
}
