package com.age.demo.mapper.login;

import com.age.demo.bean.User;

public interface UserMapper {
    User findByUsername(String userName);
    User findUserById(String idUser);
}
