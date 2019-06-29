package com.init.project.module.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserEntity {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户已授权文件
     */
    private String permission;

    /**
     * 用户已授权文件lIst
     */
    private List<String> permissionList;

    private Map<String, Boolean> allFile;
}
