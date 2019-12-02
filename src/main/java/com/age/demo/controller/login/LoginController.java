package com.age.demo.controller.login;

import com.age.demo.bean.ResponseBean;
import com.age.demo.parameter.RegisterParameter;
import com.age.demo.service.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/age/login/UserLogin")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/v1.0")
    @CrossOrigin(origins = "*")
    public ResponseBean userLogin(RegisterParameter param){
        return loginService.run(param);
    }
}
