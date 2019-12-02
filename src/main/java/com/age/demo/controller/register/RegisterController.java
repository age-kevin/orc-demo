package com.age.demo.controller.register;

import com.age.demo.bean.ResponseBean;
import com.age.demo.parameter.RegisterParameter;
import com.age.demo.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/age/register/UserRegister")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/v1.0")
    @CrossOrigin(origins = "*")
    public ResponseBean userRegister(RegisterParameter param){
        return registerService.run(param);
    }
}
