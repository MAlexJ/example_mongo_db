package com.malex.one_to_many.controller;

import com.malex.one_to_many.controller.dto.RoleRequest;
import com.malex.one_to_many.controller.dto.RoleResponse;
import com.malex.one_to_many.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleRestController {

  private final RoleService roleService;

  @GetMapping
  public ResponseEntity<List<RoleResponse>> findAll() {
    return ResponseEntity.ok(roleService.findAll());
  }

  @PostMapping
  public ResponseEntity<RoleResponse> save(@RequestBody RoleRequest request) {
    return ResponseEntity.ok(roleService.save(request));
  }
}
