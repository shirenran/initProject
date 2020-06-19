package com.init.project.swallow.service;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.init.project.swallow.dto.QuestionDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: initProject
 * @description:
 * @author: ssc
 * @create: 2019-08-01 17:51
 **/
@Service
public class QuestionService {

    public QuestionDTO get(Integer sort) throws SQLException {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setTotal(Db.use().query("select count(1) from question").get(0).getInt("count(1)"));
        List<Entity> query = Db.use().query("select * from question where sort = ?", sort);
        if (ObjectUtils.isEmpty(query)) {
            return null;
        }
        questionDTO.setSort(query.get(0).getInt("sort"));
        questionDTO.setTitle(query.get(0).getStr("title"));
        questionDTO.setA(query.get(0).getStr("a"));
        questionDTO.setB(query.get(0).getStr("b"));
        questionDTO.setC(query.get(0).getStr("c"));
        questionDTO.setD(query.get(0).getStr("d"));
        return questionDTO;
    }

}
