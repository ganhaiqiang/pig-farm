package com.ghq.pig.farm.disease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ghq.pig.farm.disease.entity.Disease;
import com.ghq.pig.farm.disease.service.IDiseaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author GHQ
 * @since 2020-09-25
 */
@Controller
@RequestMapping("/disease")
@Api(tags = { "测试测试" })
public class DiseaseController {

	@Autowired
	private IDiseaseService diseaseService;

	@GetMapping("/disease-view")
	public String index() {
		return "disease/disease-view";
	}

	@GetMapping("/hello")
	@ResponseBody
	@ApiOperation(value = "返回请求信息", notes = "根据请求参数，返回请求信息")
	@ApiImplicitParam(name = "name", value = "名字", defaultValue = "swagger")
	public String hello(@RequestParam(value = "name", defaultValue = "swagger") String name) {
		return "hello：" + name + "！";
	}

	@GetMapping("/getById")
	@ResponseBody
	@ApiOperation(value = "根据id查询", notes = "获取所有信息")
	@ApiImplicitParam(name = "id", value = "主键名字", defaultValue = "1")
	public Object getById(Integer id) {
		return diseaseService.getById(id);
	}

	@GetMapping("/getAll")
	@ResponseBody
	@ApiOperation(value = "查询所有", notes = "获取所有信息")
	public Object getAll() {
		return diseaseService.list();
	}

	@GetMapping("/getByPage")
	@ResponseBody
	@ApiOperation(value = "分页查询所有", notes = "获取所有信息")
	public Object getByPage() {
		Page<Disease> page = new Page<Disease>(1, 10);
		page.addOrder(OrderItem.descs("createTime"));
		return diseaseService.page(page);
	}
}
