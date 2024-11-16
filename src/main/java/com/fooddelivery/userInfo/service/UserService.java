package com.fooddelivery.userInfo.service;

import com.fooddelivery.userInfo.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(Integer id);

    UserDTO addUser(UserDTO user);
}
