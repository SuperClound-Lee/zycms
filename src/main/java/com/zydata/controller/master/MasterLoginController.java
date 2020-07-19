package com.zydata.controller.master;

import com.zydata.config.MasterConfigMessage;
import com.zydata.domain.master.MasterMapper;
import com.zydata.entity.master.ManagerEntity;
import com.zydata.exception.BaseException;
import com.zydata.service.master.MasterService;
import com.zydata.utils.common.RemFlag;
import com.zydata.utils.common.SystemUtils;
import com.zydata.utils.common.validationCodeUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 管理员控制器
 */
@Controller
@Log
public class MasterLoginController {


    @Autowired
    MasterMapper masterMapper;

    @Autowired
    private   MasterService masterService;

    @GetMapping("/zyadmin")
    public String adminLoginPage(){

        return "admin/login";
    }

    @PostMapping("/zyadmin/login")
    public String adminLogin(String username,String password,String validate,
                             Model model,HttpServletRequest req,HttpServletResponse repo){
        //记录登录IP与时间地址写入日志
        String Kip= SystemUtils.getIpAddr(req);
        String formart= new SimpleDateFormat("yyyy-MM-DD hh:mm:ss").format(new Date());
        log.info("IP:"+Kip+"尝试登录-----"+"登录时间："+formart);
        // 验证码效验
        Object obj =req.getSession().getAttribute("RANDOMREDISKEY");
        if(obj!=null&&obj.toString().equals(validate)){
            try{
                // 调用登录处理方法
                ManagerEntity managerEntity=masterService.masterLogin(username,password);
                // 设置登录Session信息
                req.getSession().setAttribute("uid",managerEntity.getUid());
                req.getSession().setAttribute("masterInformation",managerEntity.getUsername());
                // 用户是否选择记住密码
                RemFlag.getFlag(repo,req);
                return "redirect:/zyadmin/master";
            }catch (BaseException e){
                // 登录失败响应信息
                model.addAttribute("msg",e.getMessage());
            }
        }else{
            model.addAttribute("msg", MasterConfigMessage.VALIDATE_CODE);
        }
        return "admin/login";

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

    }

/**
 * 1.添加
 * 2.修改
 * 3.删除
 * 4.获取所有管理员信息
 * 5.统计管理员数量
 */
}


