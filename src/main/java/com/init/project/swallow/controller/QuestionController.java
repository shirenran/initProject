package com.init.project.swallow.controller;

import com.init.project.swallow.dto.QuestionDTO;
import com.init.project.swallow.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @program: initProject
 * @description:
 * @author: ssc
 * @create: 2019-08-01 17:52
 **/
@RestController
@Api
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "获取一条问题",notes = "获取一条问题")
    @GetMapping("question/get/{sort}")
    public QuestionDTO get(@PathVariable("sort") Integer sort) throws SQLException {
        return questionService.get(sort);
    }

}
