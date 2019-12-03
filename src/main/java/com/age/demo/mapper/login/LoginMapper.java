package com.age.demo.mapper.login;

import com.age.demo.bean.User;

public interface LoginMapper {
    Integer checkUserNameAndPassword(User user);
}
