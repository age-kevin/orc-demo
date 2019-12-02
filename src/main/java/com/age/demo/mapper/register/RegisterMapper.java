package com.age.demo.mapper.register;

import com.age.demo.parameter.RegisterParameter;

public interface RegisterMapper {
    Integer checkUserName(RegisterParameter param);
    void insertUser(RegisterParameter param);
}
