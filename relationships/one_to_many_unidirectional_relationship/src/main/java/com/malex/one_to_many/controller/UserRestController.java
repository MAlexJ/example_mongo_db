package com.malex.one_to_many.controller;

import com.malex.one_to_many.controller.dto.UserRequest;
import com.malex.one_to_many.controller.dto.UserResponse;
import com.malex.one_to_many.repository.entity.UserEntity;
import com.malex.one_to_many.service.UserService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> findById(@PathVariable String id) {
    Objects.requireNonNull(id, "The id cannot be null");
    return userService
        .findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<UserResponse> create(@RequestBody UserEntity user) {
    Objects.requireNonNull(user, "The user cannot be null");
    return ResponseEntity.ok(userService.create(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    Objects.requireNonNull(id, " The id cannot be null");
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody UserRequest request) {
    Objects.requireNonNull(id, "The id cannot be null");
    Objects.requireNonNull(request, "The user cannot be null");
    return ResponseEntity.ok(userService.update(id, request));
  }
}
