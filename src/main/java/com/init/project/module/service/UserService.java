package com.init.project.module.service;

import com.init.project.module.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

}

