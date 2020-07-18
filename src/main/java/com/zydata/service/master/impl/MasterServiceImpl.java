package com.zydata.service.master.impl;

import com.zydata.config.MasterConfigMessage;
import com.zydata.domain.master.MasterMapper;
import com.zydata.entity.master.ManagerEntity;
import com.zydata.exception.master.MasterException;
import com.zydata.service.master.MasterService;

import com.zydata.utils.common.validationCodeUtil;
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

    @Override
    public void masterRegister(ManagerEntity entity) {
              masterMapper.addMaster(entity);
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

    @Override
    public Integer modifyActor(Integer uid, ManagerEntity entity) {
        return masterMapper.modifyActor(uid,entity);
    }

    @Override
    public Integer deleteMaster(Integer uid) {
        return masterMapper.deleteMaster(uid);
    }





}
