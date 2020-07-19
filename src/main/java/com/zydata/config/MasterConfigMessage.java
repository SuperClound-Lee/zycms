package com.zydata.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 提示信息
 */
public class MasterConfigMessage {
    public static final String LOGIN_SUCCESS="登录成功！";
    public static final String LOGIN_ERROR="用户名或密码错误";
    public static final String VALIDATE_USERNAME="用户名为6-20位中文、数字、字母任意组合";
    public static final String VALIDATE_PASSWORD="密码为8-16位以字母开头、数字、特殊字符组合";
    public static final String VALIDATE_EMAIL="邮箱格式不正确";
    public static final String VALIDATE_PHONE="手机格式不正确";
    public static final String MASTER_ADD_SUCCESS="添加%s失败！用户已存在";
    public static final String MASTER_ADD_ERROR="添加%s用户成功";
    public static final String VALIDATE_CODE="验证码错误！";
    public static final String FAIL_TO_DEDELET="删除失败";
    public static final String UPDATE_MASTER="修改成功";
    public static final String FAIL_TO_GET="获取数据失败";

}
