package com.gq360.axurepermission.module.controller;


import com.gq360.axurepermission.module.entity.UserEntity;
import com.gq360.axurepermission.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: axurepermission
 * @description: userController
 * @author: shishaochong
 * @create: 2019-06-21 10:31
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String toRegister(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute UserEntity userEntity) {
        return userService.login(userEntity);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(@RequestBody UserEntity userEntity, HttpServletResponse response) {
        userService.update(userEntity,response);
    }

}
