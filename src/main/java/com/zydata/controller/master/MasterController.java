package com.zydata.controller.master;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员控制器
 */
@Controller
@Log
public class MasterController {

    @GetMapping("/zyadmin")
    public String adminLoginPage(){

        return "admin/index";
    }

    @PostMapping("/zyadmin/login")
    public String adminLogin(String username, String password, String validate,
    Model model, @SessionAttribute("") Object object, HttpServletRequest req){
        //TODO 记录登录IP与时间地址写入日志

        //TODO 验证码效验

        //TODO 用户是否选择记住密码

        //TODO 调用登录处理方法

        //TODO 设置登录Session信息


        log.info(username);
        return "admin/index";

    }
}
