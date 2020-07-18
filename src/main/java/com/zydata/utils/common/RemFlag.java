package com.zydata.utils.common;

import com.zydata.entity.master.ManagerEntity;
import lombok.extern.java.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log
public class RemFlag {



    public  static void  getFlag(HttpServletResponse response, HttpServletRequest request){
            String username= request.getParameter("username");
            String password= request.getParameter("password");

        if("on".equals(request.getParameter("remeber"))){
            String loginInfo=username+"-"+password;
            Cookie cookie=new Cookie("loginInfo",loginInfo);
            response.addCookie(cookie);
            cookie.setMaxAge(30*24*60*60);
            cookie.setPath("/");
            response.addCookie(cookie);

        }

    }
}
