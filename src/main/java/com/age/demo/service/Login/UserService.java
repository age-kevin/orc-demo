package com.age.demo.service.Login;

import com.age.demo.bean.User;
import com.age.demo.mapper.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByUsername(User user){
        return userMapper.findByUsername(user.getUserName());
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }
}
