package com.areanoise.mapper;

import com.areanoise.model.users.UserEntity;
import com.areanoise.spec.model.UserDTO;
import com.areanoise.spec.model.UserPostRequestDTO;
import com.areanoise.spec.model.UserPostResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDTO userEntityToUserDTO (UserEntity userEntity);

  UserPostResponseDTO userEntityToUserPostResponseDTO (UserEntity userEntity);

  UserEntity userPostRequestDTOToUserEntity (UserPostRequestDTO userPostRequestDTO);
}
