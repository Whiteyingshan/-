package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("sys_user")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {
	/**主键*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**所属角色*/
    @ApiModelProperty(value = "所属角色")
    private String roles;
    /**描述*/
    @ApiModelProperty(value = "描述")
    private String introduction;
    /**头像*/
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**名称*/
    @ApiModelProperty(value = "名称")
    private String name;
    /**密码*/
    @ApiModelProperty(value = "密码")
    private String password;
}
