package com.ghq.pig.farm.feeding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_feeding")
@ApiModel(value = "Feeding对象", description = "")
public class Feeding implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value = "饲养程序")
	private String name;

	@ApiModelProperty(value = "阶段")
	private String stage;

	@ApiModelProperty(value = "工作内容")
	private String job;

	@ApiModelProperty(value = "距前一个阶段间隔天数")
	private Integer spacing;

	@ApiModelProperty(value = "步骤")
	private Integer step;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "创建日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

}
