package com.gq360.axurepermission.module.service;

import com.google.common.base.Joiner;
import com.gq360.axurepermission.module.entity.UserEntity;
import com.gq360.axurepermission.module.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @program: axurepermission
 * @description: user业务类
 * @author: ssc
 * @create: 2019-06-21 10:17
 **/
@Service
public class UserService {

    @Value("${file.path}")
    private String filePath;
    @Value("${url}")
    private String url;
    @Value("${admin}")
    private String admin;

    @Autowired
    private UserMapper userMapper;


    public ModelAndView login(UserEntity userEntity){
        ModelAndView mav = new ModelAndView();
        UserEntity user = userMapper.selectByAccount(userEntity.getAccount());
        if (user == null ||  !user.getPassword().equals(userEntity.getPassword())){
            mav.setViewName("login");
            mav.addObject("error", "密码错误");
            return mav;
        }
        if (admin.equals(user.getAccount())) {
            return admin();
        }
        mav.setViewName("loginSuccess");
        mav.addObject("userFile", userPermissionToList(user.getPermission()));
        mav.addObject("url",url);
        return mav;
    }

    public void update(UserEntity userEntity, HttpServletResponse response){
        userEntity.setPermission(userPermissionToString(userEntity.getPermissionList()));
        Integer update = userMapper.update(userEntity);
        String msg;
        if (update != 1){
            msg = "fail";
        } else {
            msg = "success";
        }
        try {
            response.getWriter().print(msg);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private List<String> getAllFile(){
        File file = new File(filePath);
        List<String> fileList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            fileList.add(file1.getName());
        }
        return fileList;
    }

    private List<String> userPermissionToList(String permission){
        return Arrays.asList(permission.split(","));
    }

    private String userPermissionToString(List<String> strings){
        return Joiner.on(",").join(strings);
    }

    private ModelAndView admin(){
        ModelAndView mav = new ModelAndView();
        //获得所有用户
        List<UserEntity> allUser = userMapper.selectAllUser(admin);
        //获取所有文件
        List<String> file = getAllFile();
        for (UserEntity userEntity : allUser) {
            Map<String,Boolean> allFile = new HashMap<>();
            for (String s : file) {
                allFile.put(s, Boolean.FALSE);
            }
            List<String> list = userPermissionToList(userEntity.getPermission());
            for (String s : allFile.keySet()) {
                if (list.contains(s)) {
                    allFile.put(s, Boolean.TRUE);
                }
            }
            userEntity.setAllFile(allFile);
            userEntity.setPermissionList(userPermissionToList(userEntity.getPermission()));
        }
        mav.addObject("allUser", allUser);
        mav.setViewName("back");
        return mav;
    }
}

