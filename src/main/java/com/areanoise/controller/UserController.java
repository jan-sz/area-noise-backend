package com.areanoise.controller;

import com.areanoise.service.UserService;
import com.areanoise.spec.api.UserApi;
import com.areanoise.spec.model.UserDTO;
import com.areanoise.spec.model.UserPostRequestDTO;
import com.areanoise.spec.model.UserPostResponseDTO;
import com.areanoise.spec.model.UserUpdatePutRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.ConstrainedTo;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserPostResponseDTO> addUser(@Valid UserPostRequestDTO userPostRequestDTO) {
        return ResponseEntity.ok(userService.addUser(userPostRequestDTO));
    }

    @Override
    public ResponseEntity<UserDTO> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long userId, @Valid UserUpdatePutRequestDTO userUpdatePutRequestDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userUpdatePutRequestDTO));
    }
}
