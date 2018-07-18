package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    List<UserVO> users = new ArrayList<>();
    public void createUser(UserVO user){
        users.add(user);
    }
    public void deleteUser(String username){
        for (UserVO user: users){
            if (user.getUsername().equals(username)){
                users.remove(user);
            }
        }
    }

    public List<UserVO> getUsers() {
        return users;
    }
}
