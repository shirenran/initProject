package com.init.project.swallow.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.springframework.stereotype.Service;
import com.init.project.swallow.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: helloworld
 * @description:
 * @author: ssc
 * @create: 2019-08-01 16:45
 **/
@Service
public class UserService {

    public Boolean insert(String openid,Integer score){
        try {
            Db.use().insert(Entity.create("user").set("openid",openid).set("score",score));
            return Boolean.TRUE;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public List<UserDTO> findAll(String openid) throws SQLException {
        List<Entity> query = Db.use().query("select * from user where openid = ? order by id desc",openid);
        List<UserDTO> list = CollectionUtil.newArrayList();
        for (Entity entity : query) {
            UserDTO userDTO = new UserDTO();
            userDTO.setScore(entity.getInt("score"));
            userDTO.setCreateTime(entity.getStr("create_time").replace(".0",""));
            list.add(userDTO);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        new UserService().findAll("123");
    }

}
