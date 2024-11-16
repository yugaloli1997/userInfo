package com.fooddelivery.userInfo.mapper;


import com.fooddelivery.userInfo.dto.UserDTO;
import com.fooddelivery.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOtoUserEntity(UserDTO userDTO);

    UserDTO mapUserEntitytoUserDTO(User userEntity);

}
