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
            Cookie cookie=new Cookie("username",username);
            Cookie cookie2= new Cookie("password",password);
            cookie.setMaxAge(30*24*60*60);
            cookie2.setMaxAge(30*24*60*60);
            cookie.setPath("/");
            cookie2.setPath("/");
            response.addCookie(cookie);
            response.addCookie(cookie2);

        }

    }
}
