package com.zydata.service.master.impl;

import com.zydata.config.MasterConfigMessage;
import com.zydata.domain.master.MasterMapper;
import com.zydata.entity.master.ManagerEntity;
import com.zydata.exception.master.MasterException;
import com.zydata.service.master.MasterService;

import com.zydata.utils.common.validationCodeUtil;
import com.zydata.utils.master.Validate;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;


import java.util.List;
import java.util.UUID;
@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    private  MasterMapper masterMapper;

    @Override
    public ManagerEntity masterLogin(String username,String password) throws MasterException{
        //TODO 获取当前登录账户信息
        ManagerEntity managerEntity=masterMapper.getMaster(username);
        //TODO 用户输入密码效验
        if(managerEntity !=null){
            //TODO 用户输入密码加密
            String m=validationCodeUtil.toMD5(password, managerEntity.getToken());
            if(m.equals(managerEntity.getPassword())){
                return managerEntity;
            }else{
                throw new MasterException(MasterConfigMessage.LOGIN_ERROR);
            }
        }else {

            //TODO 返回实体对象 登录失败调用异常类 MasterException 提示信息在MasterConfigMessage中
            throw new MasterException(MasterConfigMessage.LOGIN_ERROR);
        }


    }
    /*
        @RequestMapping("/xx")
        public   void conteSxtLoads() {
            ManagerEntity x=new ManagerEntity();
            x.setUsername("77");
            String h=validationCodeUtil.salt();
            String f=validationCodeUtil.toMD5("77",h);
            x.setPassword(f);
            x.setToken(h);
            x.setPhone("7777");
            x.setEmail("7777@qq.com");
            x.setActor(644);
            x.setCreate_time(new Date());
            x.setModify_time(new Date());
            masterMapper.addMaster(x);
        }*/
    @Override
    public void masterRegister(ManagerEntity entity)throws MasterException{
        //TODO 获取传回来的用户名
        String x=entity.getUsername();
        //TODO 获取密码
        String p=entity.getPassword();
        //TODO 获取邮箱
        String email=entity.getEmail();
        //TODO 获取手机号
        String phone=entity.getPhone();
        //TODO 判断是否是注册 这里需要保持username是唯一值
       if(Validate.ValidateUsername(x)==false){
           throw  new MasterException(MasterConfigMessage.MASTER_ADD_SUCCESS);
       }
        if(Validate.ValidatePassword(p)==false){
            throw  new MasterException(MasterConfigMessage.VALIDATE_PASSWORD);
        }
        if(Validate.ValidateEmail(email)==false){
            throw  new MasterException(MasterConfigMessage.VALIDATE_EMAIL);
        }
        if(Validate.ValidatePhone(phone)==false){
            throw  new MasterException(MasterConfigMessage.VALIDATE_PHONE);
        }
        masterMapper.addMaster(entity);
    }

    @Override
    public Integer deleteMaster(Integer uid) {
        return masterMapper.deleteMaster(uid);
    }



    @Override
    public Integer modifyActor(Integer uid, ManagerEntity entity) {

        return masterMapper.modifyActor(uid,entity);
    }


    @Override
    public ManagerEntity getMaster(Integer uid) {
        return masterMapper.getMasterUseID(uid);
    }




    @Override
    public List<ManagerEntity> getMaster()
    {
        return masterMapper.getMasterBase();
    }









}
