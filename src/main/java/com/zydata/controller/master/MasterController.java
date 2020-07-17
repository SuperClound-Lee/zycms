package com.zydata.controller.master;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    Model model){
        //TODO
        log.info(username);
        return "admin/index";

    }
}
