package com.age.demo.service.register;

import com.age.demo.bean.ResponseBean;
import com.age.demo.mapper.register.RegisterMapper;
import com.age.demo.parameter.RegisterParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    RegisterMapper registerMapper;

    public ResponseBean run(RegisterParameter param){
        registerMapper.insertUser(param);
        return ResponseBean.actionSuccess("", "");
    }
}
