package com.fooddelivery.userInfo.service;

import com.fooddelivery.userInfo.dto.UserDTO;
import com.fooddelivery.userInfo.entity.User;
import com.fooddelivery.userInfo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fooddelivery.userInfo.repo.UserRepo;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDTO getUserById(Integer id) {

        Optional<User> userEntity = userRepo.findById(id);
        return userEntity.map(UserMapper.INSTANCE::mapUserEntitytoUserDTO).orElse(null);
    }

    @Override
    public UserDTO addUser(UserDTO user) {

        Optional<User> userEntity = userRepo.findById(user.getId());
        User userUpdated = userEntity.get();
        userUpdated.setUserName(user.getUserName());
        userUpdated.setAddress(user.getAddress());
        userUpdated.setCity(user.getCity());
        userUpdated.setPassword(user.getPassword());
        userRepo.save(userUpdated);
        //User userEntity = userRepo.save(UserMapper.INSTANCE.mapUserDTOtoUserEntity(user));
        return  UserMapper.INSTANCE.mapUserEntitytoUserDTO(userUpdated);
    }
}
