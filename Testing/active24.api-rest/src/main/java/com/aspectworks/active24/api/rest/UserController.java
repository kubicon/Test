package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserServiceImpl userService;
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserVO user){
        userService.createUser(user);
        System.out.println("Creating new user: " + user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public void deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        System.out.println("Deleting user with username: " + username);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserVO> getAllUsers(){/*
        List<UserVO> users = new ArrayList<>();
        UserVO userVO = new UserVO();
        userVO.setUsername("user1");
        userVO.setFirstName("Tomas");
        userVO.setSurname("Blabol");
        users.add(userVO);
        userVO = new UserVO();
        userVO.setUsername("user2");
        userVO.setFirstName("Martin");
        userVO.setSurname("Blabolek");
        users.add(userVO);
        return users;*/
        return userService.getUsers();
    }

}
