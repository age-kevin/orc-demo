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
        if (param != null) {
            int count = registerMapper.checkUserName(param);
            if (count > 0) {
                return ResponseBean.actionSuccess("1", "用户名已存在！");
            } else {
                registerMapper.insertUser(param);
                return ResponseBean.actionSuccess("0", "注册成功！");
            }
        } else {
            return ResponseBean.actionSuccess("1", "未接受到参数！");
        }
    }
}
