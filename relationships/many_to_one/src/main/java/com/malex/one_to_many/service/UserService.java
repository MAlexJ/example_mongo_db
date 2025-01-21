package com.malex.one_to_many.service;

import com.malex.one_to_many.controller.dto.UserRequest;
import com.malex.one_to_many.controller.dto.UserResponse;
import com.malex.one_to_many.mapper.ObjectMapper;
import com.malex.one_to_many.repository.RoleRepository;
import com.malex.one_to_many.repository.UserRepository;
import com.malex.one_to_many.repository.entity.RoleEntity;
import com.malex.one_to_many.repository.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final ObjectMapper objectMapper;

  private final RoleRepository roleRepository;
  private final UserRepository userRepository;

  public List<UserResponse> findAll() {
    return userRepository.findAll().stream().map(objectMapper::entityToDto).toList();
  }

  public Optional<UserResponse> findById(String id) {
    return userRepository.findById(id).map(objectMapper::entityToDto);
  }

  public UserResponse create(UserEntity user) {

    // Many to One
    Optional.ofNullable(user.getRole())
        .map(RoleEntity::getId)
        .flatMap(roleRepository::findById)
        .ifPresent(user::setRole);

    var persistUserEntity = userRepository.save(user);
    return objectMapper.entityToDto(persistUserEntity);
  }

  public void deleteById(String id) {
    userRepository.deleteById(id);
  }

  public UserResponse update(String id, UserRequest dto) {
    throw new UnsupportedOperationException();
  }
}
