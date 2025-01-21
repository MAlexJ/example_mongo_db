package com.malex.one_to_many.controller.dto;

import com.malex.one_to_many.repository.entity.RoleEntity;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserRequest {

  private String id;

  private Long userId;

  private RoleEntity role;

  private LocalDateTime created;

  private LocalDateTime updated;
}
