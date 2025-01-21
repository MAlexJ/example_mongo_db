package com.malex.one_to_many.controller.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserResponse {

  private String id;

  private Long userId;

  private RoleResponse role;

  private LocalDateTime created;

  private LocalDateTime updated;
}
