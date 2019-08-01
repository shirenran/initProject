package com.init.project.swallow.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.init.project.swallow.dto.UserDTO;
import com.init.project.swallow.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: initProject
 * @description:
 * @author: ssc
 * @create: 2019-08-01 17:26
 **/
@RestController
@Api
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "插入", notes = "插入")
    @GetMapping("/user/insert/{openid}/{score}")
    public boolean insert(@PathVariable("openid") String openid, @PathVariable("score") Integer score) {
        return userService.insert(openid, score);
    }

    @ApiOperation(value = "查询", notes = "查询")
    @GetMapping("/user/get/{openid}")
    public List<UserDTO> findAll(@PathVariable("openid") String openid) throws SQLException {
        return userService.findAll(openid);
    }

}
