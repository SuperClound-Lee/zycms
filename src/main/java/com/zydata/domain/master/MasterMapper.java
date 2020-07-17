package com.zydata.domain.master;

import com.zydata.entity.master.ManagerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MasterMapper {
    /**
     * 根据账号查询单个管理账户
     * @param username 账户
     * @return 账户信息
     */
    ManagerEntity getMaster(String username);

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
     * 新增账户
     * @param entity 账户信息
     */
    void addMaster(ManagerEntity entity);
}
