package com.zydata.service.master;

import com.zydata.entity.master.ManagerEntity;
import com.zydata.exception.master.MasterException;

import java.util.List;

public interface MasterService {

    /**
     * 登录
     * @param username 账户
     * @return 账户信息
     */
    ManagerEntity masterLogin(String username,String password) throws MasterException;

    /**
     * 根据ID查询单个管理账户
     * @param uid 账号ID
     * @return 账户信息
     */
    ManagerEntity getMaster(Integer uid);

    /**
     * 查询所有管理账户
     * @return 所有账户信息
     */
    List<ManagerEntity> getMaster();

    /**
     * 修改账号信息
     * @param uid 账户ID
     * @param entity 修改账号信息
     * @return 执行结果
     */
    Integer modifyActor(Integer uid,ManagerEntity entity);

    /**
     * 删除账户
     * @param uid 账户ID
     * @return 执行结果
     */
    Integer deleteMaster(Integer uid);

    /**
     * 注册
     * @param entity 账户信息
     */
    void masterRegister(ManagerEntity entity);

}
