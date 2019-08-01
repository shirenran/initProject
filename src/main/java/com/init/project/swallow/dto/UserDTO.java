package com.init.project.swallow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: helloworld
 * @description:
 * @author: ssc
 * @create: 2019-08-01 16:47
 **/
@Data
@ApiModel
public class UserDTO {

    @ApiModelProperty
    private String openid;

    @ApiModelProperty
    private Integer score;

    @ApiModelProperty
    private String createTime;
}
