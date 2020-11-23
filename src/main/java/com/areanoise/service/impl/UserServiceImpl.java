package com.areanoise.service.impl;

import com.areanoise.mapper.UserMapper;
import com.areanoise.model.users.UserEntity;
import com.areanoise.repository.UserRepository;
import com.areanoise.service.UserService;
import com.areanoise.spec.model.UserDTO;
import com.areanoise.spec.model.UserPostRequestDTO;
import com.areanoise.spec.model.UserPostResponseDTO;
import com.areanoise.spec.model.UserUpdatePutRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserPostResponseDTO addUser(UserPostRequestDTO userPostRequestDTO) {
        UserEntity userEntity = userMapper.userPostRequestDTOToUserEntity(userPostRequestDTO);
        log.info("UserServiceImpl.addUser = " + userEntity.toString());
        return userMapper.userEntityToUserPostResponseDTO(userRepository.saveAndFlush(userEntity));
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userMapper.userEntityToUserDTO(userRepository.getOne(userId));
    }

    @Override
    public UserDTO updateUser(Long userId, UserUpdatePutRequestDTO userUpdatePutRequestDTO) {
        UserEntity userEntity = userRepository.getOne(userId);
        userEntity.setFavoriteAnimal(userUpdatePutRequestDTO.getFavoriteAnimal());
        return userMapper.userEntityToUserDTO(userRepository.saveAndFlush(userEntity));
    }
}
