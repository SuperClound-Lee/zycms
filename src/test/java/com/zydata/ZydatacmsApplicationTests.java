package com.zydata;

import com.zydata.domain.master.MasterMapper;
import com.zydata.entity.master.ManagerEntity;
import com.zydata.utils.common.validationCodeUtil;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;


@SpringBootTest
class ZydatacmsApplicationTests {
       @Autowired
    MasterMapper masterMapper;
       /*
       *  private String username;
    private String password;
    private String token;
    private String phone;
    private String email;
    private Integer actor;
    private String charnam; //等级名称
    private Date create_time;
    private Date modify_time;
       * */
    @Test
    void conteSxtLoads() {
        ManagerEntity x=new ManagerEntity();
        x.setUsername("33");
        String h=validationCodeUtil.salt();
        String f=validationCodeUtil.toMD5("33",h);
        x.setPassword(f);
        x.setToken(h);
        x.setPhone("33333333");
        x.setEmail("2331231@qq.com");
        x.setActor(644);
        x.setCreate_time(new Date());
        x.setModify_time(new Date());

    }
}