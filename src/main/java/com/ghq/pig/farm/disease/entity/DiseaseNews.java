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
@TableName("t_disease_news")
@ApiModel(value = "DiseaseNews对象", description = "")
public class DiseaseNews implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键ID")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "摘要")
	private String summary;

	@ApiModelProperty(value = "正文")
	private String content;

	@ApiModelProperty(value = "来源")
	private String source;

	@ApiModelProperty(value = "类型")
	private String type;

	@ApiModelProperty(value = "添加日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createTime;

}
