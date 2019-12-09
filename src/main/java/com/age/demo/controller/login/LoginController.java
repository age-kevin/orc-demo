package com.age.demo.controller.login;

import com.age.demo.annotation.UserLoginToken;
import com.age.demo.bean.ResponseBean;
import com.age.demo.bean.User;
import com.age.demo.service.Login.UserService;
import com.age.demo.service.token.TokenService;
import com.age.demo.util.TokenUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/age")
public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    // 登录
    @GetMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseBean login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase != null) {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                return ResponseBean.actionFail("登录失败,密码错误");
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);

                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                response.addCookie(cookie);

                return ResponseBean.actionSuccess(jsonObject, "登录成功");
            }
        } else {
            return ResponseBean.actionFail("该用户不存在");
        }
    }
    /***
     * 这个请求需要验证token才能访问
     *
     * @author: Age
     * @date 2019/12/03
     * @return String 返回类型
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        LOG.info(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
