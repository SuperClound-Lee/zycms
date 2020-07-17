package com.zydata.utils.master;


/**
 * @author 中源数据
 * 管理员信息数据效验
 */
public class Validate {

    //支持中文字母数字
    private static final String REGEX_USER="[0-9a-zA-Z\\u4E00-\\u9FA5]+[^\\s]{6,20}";
    //8位以上以字母开头
    private static final String REGEX_PWD="^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
    //邮箱
    private static final String REGEX_EMAIL="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    //手机
    private static final String REGEX_PHONE="^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";

    /**
     * 效验用户名
     * @param username 用户输入账号
     * @return 效验结果
     */
    public static Boolean ValidateUsername(String username){
       if(username!=null){
           return username.matches(REGEX_USER);
       }else{
           return false;
       }
    }

    /**
     * 用户密码效验
     * @param password 用户输入密码
     * @return 效验结果
     */
    public static Boolean ValidatePassword(String password){
        if(password!=null){
            return password.matches(REGEX_PWD);
        }else{
            return false;
        }
    }

    /**
     * 邮箱效验
     * @param email 邮箱地址
     * @return 效验结果
     */
    public static Boolean ValidateEmail(String email){
        if(email!=null){
            return email.matches(REGEX_EMAIL);
        }else{
            return false;
        }
    }

    /**
     * 手机效验
     * @param Phone 手机号
     * @return 效验结果
     */
    public static Boolean ValidatePhone(String Phone){
        if(Phone!=null){
            return Phone.matches(REGEX_PHONE);
        }else{
            return false;
        }
    }


}
