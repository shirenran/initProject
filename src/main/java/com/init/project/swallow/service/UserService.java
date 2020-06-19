package com.init.project.swallow.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.fastjson.JSONObject;
import com.init.project.swallow.dto.UserDTO;
import com.init.project.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helloworld
 * @description:
 * @author: ssc
 * @create: 2019-08-01 16:45
 **/
@Service
public class UserService {

//    @Value("${getOpenid.url}")
//    private String getOpenidUrl;
//    @Value("${loginRequestGrantType}")
//    private String grantType;
//    @Value("${appId}")
//    private String appId;
//    @Value("${appSecret}")
//    private String appSecret;

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

//    /**
//     * 根据code获取openid
//     * @param code
//     * @return
//     * @throws Exception
//     */
//    public String getOpenid(String code){
//        Map<String, Object> getParams = new LinkedHashMap<>();
//        getParams.put("appid", appId);
//        getParams.put("secret", appSecret);
//        getParams.put("js_code", code);
//        getParams.put("grant_type", grantType);
//        String result = null;
//        try {
//            result = HttpUtil.get(getOpenidUrl, getParams, 0, 0);
//        } catch (Exception e) {
//        }
//        JSONObject resultJson = JSONObject.parseObject(result);
//        Integer errCode = resultJson.getInteger("errcode");
//        String errMsg = resultJson.getString("errmsg");
//        String openid = resultJson.getString("openid");
//        String sessionKey = resultJson.getString("session_key");
//        return openid;
//    }


}
