package com.zydata.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zyadmin")
public class MasterController {

    @RequestMapping("/master")
    public String master(Model model){

        return "admin/index";
    }


}
