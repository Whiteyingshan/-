package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@TableName("employee")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Employee implements Serializable {
	/**主键*/
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**职员姓名*/
    @ApiModelProperty(value = "职员姓名")
    private String empName;
    /**性别*/
    @ApiModelProperty(value = "性别")
    private String sex;
    /**年龄*/
    @ApiModelProperty(value = "年龄")
    private String age;
    /**部门名称*/
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    /**学历*/
    @ApiModelProperty(value = "学历")
    private String empDegreeName;
}
