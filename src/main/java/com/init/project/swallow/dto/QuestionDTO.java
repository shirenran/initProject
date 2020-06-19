package com.init.project.swallow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: initProject
 * @description:
 * @author: ssc
 * @create: 2019-08-01 17:51
 **/
@Data
@ApiModel
public class QuestionDTO {

    @ApiModelProperty
    private Integer sort;

    @ApiModelProperty
    private String title;

    @ApiModelProperty
    private String a;

    @ApiModelProperty
    private String b;

    @ApiModelProperty
    private String c;

    @ApiModelProperty
    private String d;

    @ApiModelProperty
    private Integer total;

}
