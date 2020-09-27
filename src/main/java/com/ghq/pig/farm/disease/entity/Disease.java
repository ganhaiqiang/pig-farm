package com.ghq.pig.farm.disease.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

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
 * @since 2020-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_disease")
@ApiModel(value = "Disease对象", description = "")
public class Disease implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value = "疾病名称")
	private String name;

	@ApiModelProperty(value = "症状表现")
	private String symptoms;

	@ApiModelProperty(value = "治疗处方")
	private String measure;

	@ApiModelProperty(value = "防疫措施")
	private String cause;

	@ApiModelProperty(value = "参考图片")
	private String image;

	@ApiModelProperty(value = "创建日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createTime;

}
