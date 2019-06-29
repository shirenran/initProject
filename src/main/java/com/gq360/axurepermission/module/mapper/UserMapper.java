package com.gq360.axurepermission.module.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gq360.axurepermission.module.entity.UserEntity;

import java.util.List;

/**
 * @program: axurepermission
 * @description:
 * @author: shishaochong
 * @create: 2019-06-21 10:20
 **/
public interface UserMapper extends BaseMapper<UserEntity> {


    /**
     * selectById
     * @param account
     * @return
     */
    UserEntity selectByAccount(String account);

    /**
     * insert
     * @param userEntity
     * @return
     */
    @Override
    Integer insert(UserEntity userEntity);

    /**
     * selectAllUser
     * @return
     */
    List<UserEntity> selectAllUser(String admin);

    Integer update(UserEntity userEntity);

}
