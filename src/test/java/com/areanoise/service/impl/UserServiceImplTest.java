package com.areanoise.service.impl;

import com.areanoise.mapper.UserMapper;
import com.areanoise.model.users.UserEntity;
import com.areanoise.repository.UserRepository;
import com.areanoise.spec.model.UserDTO;
import com.areanoise.spec.model.UserPostRequestDTO;
import com.areanoise.spec.model.UserPostResponseDTO;
import com.areanoise.spec.model.UserUpdatePutRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock UserRepository userRepository;

  @Mock UserMapper userMapper;

  @InjectMocks UserServiceImpl userService;

  @Test
  void addUser() {
    String name = "testName";
    String favoriteAnimal = "testDog";
    UserPostRequestDTO userPostRequestDTO =
        UserPostRequestDTO.builder().username(name).favoriteAnimal(favoriteAnimal).build();
    UserEntity userEntityInsert =
        UserEntity.builder().username(name).favoriteAnimal(favoriteAnimal).build();
    Long userId = 1L;
    UserEntity userEntityCreated =
        UserEntity.builder().userId(userId).username(name).favoriteAnimal(favoriteAnimal).build();
    UserPostResponseDTO userPostResponseDTO = UserPostResponseDTO.builder().userId(userId).build();

    Mockito.when(userMapper.userPostRequestDTOToUserEntity(userPostRequestDTO))
        .thenReturn(userEntityInsert);
    Mockito.when(userRepository.saveAndFlush(Mockito.any(UserEntity.class)))
        .thenReturn(userEntityCreated);
    Mockito.when(userMapper.userEntityToUserPostResponseDTO(userEntityCreated))
        .thenReturn(userPostResponseDTO);

    UserPostResponseDTO result = userService.addUser(userPostRequestDTO);
    Assertions.assertEquals(userId, result.getUserId());
  }

  @Test
  void getUser() {
    Long userId = 1L;
    String name = "testName";
    String favoriteAnimal = "testDog";

    UserDTO expectedResult =
        UserDTO.builder().userId(userId).favoriteAnimal(favoriteAnimal).username(name).build();
    UserEntity userEntity =
        UserEntity.builder().userId(userId).favoriteAnimal(favoriteAnimal).username(name).build();
    Mockito.when(userRepository.getOne(userId)).thenReturn(userEntity);
    Mockito.when(userMapper.userEntityToUserDTO(userEntity)).thenReturn(expectedResult);

    UserDTO result = userService.getUser(userId);
    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  void updateUser() {
    Long userId = 1L;
    String name = "testName";
    String favoriteAnimal = "testDog";

    UserUpdatePutRequestDTO userUpdatePutRequestDTO =
        UserUpdatePutRequestDTO.builder().favoriteAnimal(favoriteAnimal).build();
    UserDTO expectedResult =
        UserDTO.builder().userId(userId).favoriteAnimal(favoriteAnimal).username(name).build();
    UserEntity userEntity =
        UserEntity.builder().userId(userId).favoriteAnimal(favoriteAnimal).username(name).build();
    Mockito.when(userRepository.getOne(userId)).thenReturn(userEntity);
    Mockito.when(userRepository.saveAndFlush(Mockito.any(UserEntity.class))).thenReturn(userEntity);
    Mockito.when(userMapper.userEntityToUserDTO(userEntity)).thenReturn(expectedResult);

    UserDTO result = userService.updateUser(userId, userUpdatePutRequestDTO);
    Assertions.assertEquals(expectedResult, result);
  }
}
