package com.zydata.service.master.impl;

import com.zydata.entity.master.ManagerEntity;
import com.zydata.service.master.MasterService;

import java.util.List;

public class MasterServiceImpl implements MasterService {

    @Override
    public ManagerEntity masterLogin(String username,String password) {
        //TODO 获取当前登录账户信息

        //TODO 用户输入密码加密

        //TODO 用户输入密码效验

        //TODO 返回实体对象 登录失败调用异常类 MasterException 提示信息在MasterConfigMessage中
        return null;
    }

    @Override
    public void masterRegister(ManagerEntity entity) {

    }
    @Override
    public ManagerEntity getMaster(Integer uid) {
        return null;
    }

    @Override
    public List<ManagerEntity> getMaster() {
        return null;
    }

    @Override
    public Integer modifyActor(Integer uid, ManagerEntity entity) {
        return null;
    }

    @Override
    public Integer deleteMaster(Integer uid) {
        return null;
    }




}
