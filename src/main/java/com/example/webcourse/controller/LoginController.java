package com.example.webcourse.controller;

import com.example.webcourse.model.User;
import com.example.webcourse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jiaxin on 2017/8/1.
 */
//@Controller注解用于标示本类为web层控制组件
@Controller
//@RequestMapping("/user")用于标定访问时对url位置
@RequestMapping("/user")
//在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
@Scope("prototype")
public class LoginController {
    @Autowired
    LoginService loginService;
    //login业务的访问位置为/user/login
    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request){
        //调用login方法来验证是否是注册用户
        boolean loginType = loginService.login(user.getUsername(),user.getPassword());
        if(loginType){
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("user",user);
            //并跳转到success.jsp页面
            return "success";
        }else{
            //若不对,则将错误信息显示到错误页面
            request.setAttribute("message","用户名密码错误");
            return "error";
        }
        new ModelAndView()
    }

}
