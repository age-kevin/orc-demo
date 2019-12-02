package com.age.demo.service.Login;

import com.age.demo.bean.ResponseBean;
import com.age.demo.mapper.login.LoginMapper;
import com.age.demo.parameter.RegisterParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;

    public ResponseBean run(RegisterParameter param){
        if (param != null) {
            int count = loginMapper.checkUserNameAndPassword(param);
            if (count > 0) {
                return ResponseBean.actionSuccess("0", "登录成功！");
            } else {
                return ResponseBean.actionSuccess("1", "登录失败！");
            }
        } else {
            return ResponseBean.actionSuccess("1", "请输入用户名密码！");
        }
    }
}
