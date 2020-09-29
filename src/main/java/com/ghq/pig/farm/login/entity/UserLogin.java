package com.ghq.pig.farm.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author GHQ
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user_login")
@ApiModel(value="UserLogin对象", description="")
public class UserLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "登录名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String pwd;

    @ApiModelProperty(value = "最近登录日期")
    private LocalDateTime loginTime;

    @ApiModelProperty(value = "注册日期")
    private LocalDateTime createTime;

    private Boolean enable;


}
