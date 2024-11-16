package com.fooddelivery.userInfo.controller;

import com.fooddelivery.userInfo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fooddelivery.userInfo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Integer id){

        UserDTO  user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user){

        UserDTO userdto = userService.addUser(user);
        return new ResponseEntity<>(userdto, HttpStatus.ACCEPTED);
    }

    @PostMapping("/updateuser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user){

        UserDTO userdto = userService.addUser(user);
        return new ResponseEntity<>(userdto, HttpStatus.ACCEPTED);
    }

}
