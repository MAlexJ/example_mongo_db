package com.malex.one_to_many.service;

import com.malex.one_to_many.controller.dto.RoleRequest;
import com.malex.one_to_many.controller.dto.RoleResponse;
import com.malex.one_to_many.mapper.ObjectMapper;
import com.malex.one_to_many.repository.RoleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

  private final ObjectMapper objectMapper;
  private final RoleRepository roleRepository;

  public List<RoleResponse> findAll() {
    return roleRepository.findAll().stream().map(objectMapper::entityToDto).toList();
  }

  public RoleResponse save(RoleRequest dto) {
    var entity = objectMapper.dtoToEntity(dto);
    var persistEntity = roleRepository.save(entity);
    return objectMapper.entityToDto(persistEntity);
  }
}
