package com.areanoise.service;

import com.areanoise.spec.model.UserDTO;
import com.areanoise.spec.model.UserPostRequestDTO;
import com.areanoise.spec.model.UserPostResponseDTO;
import com.areanoise.spec.model.UserUpdatePutRequestDTO;

public interface UserService {

    UserPostResponseDTO addUser(UserPostRequestDTO userPostRequestDTO);

    UserDTO getUser(Long userId);

    UserDTO updateUser(Long userId, UserUpdatePutRequestDTO userUpdatePutRequestDTO);
}