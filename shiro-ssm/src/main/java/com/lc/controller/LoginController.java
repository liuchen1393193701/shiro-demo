package com.lc.controller;

import com.lc.pojo.User;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * @PackageName: com.lc.controller
 * @ClassName: LoginController
 * @Author: liuchen
 * @Date: 2020/1/8 10:42
 * @Description: //TODO
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("goLogin.html")
    public String goLogin(){
        return "login";
    }
    @RequestMapping("login.html")
    public String login(String userName, String password, HttpServletRequest request){
        System.out.println(userService);
        User user = userService.getLogin(userName, password);
        if (null==user){
            request.setAttribute("error","用户名或密码错误");
            return "login";
        }else {
            return "redirect:index.html";
        }
    }
}
