package com.age.demo.mapper.login;

import com.age.demo.parameter.RegisterParameter;

public interface LoginMapper {
    Integer checkUserNameAndPassword(RegisterParameter param);
}
