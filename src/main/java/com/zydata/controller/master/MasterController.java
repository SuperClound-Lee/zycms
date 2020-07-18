package com.zydata.controller.master;

import com.zydata.utils.common.validationCodeUtil;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/createImg")
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            validationCodeUtil randomValidateCode = new validationCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片
        } catch(Exception e){
            e.printStackTrace();
        }
        //从session中取出随机验证码
        System.out.println(request.getSession().getAttribute("RANDOMREDISKEY"));
    }



}


