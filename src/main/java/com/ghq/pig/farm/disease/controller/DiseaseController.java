package com.ghq.pig.farm.disease.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ghq.pig.farm.common.ApiResponse;
import com.ghq.pig.farm.common.Response;
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

	@GetMapping("/disease-list")
	@ResponseBody
	public ModelAndView list() {
		return new ModelAndView("disease/disease-list");
	}

	@GetMapping("/disease-page")
	@ResponseBody
	public Response page(@RequestParam("page") Long current, @RequestParam("limit") Long pageSize) {
		Page<Disease> page = new Page<Disease>(current, pageSize);
		page.addOrder(OrderItem.descs("create_time"));
		page = diseaseService.page(page);
		return ApiResponse.ok(page);
	}

	@GetMapping("/disease-save")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView("disease/disease-save");
		if (id != null && id > 0) {
			Disease disease = diseaseService.getById(id);
			return modelAndView.addObject("disease", disease);
		}
		return modelAndView;
	}

	@GetMapping("/disease-view")
	public ModelAndView view() {
		return new ModelAndView("disease/disease-view");
	}

	@PostMapping("/disease-del")
	@ResponseBody
	public Response del(@NotBlank(message = "ids不能为空") String ids) {
		List<Integer> idList = Stream.of(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
		boolean flag = diseaseService.removeByIds(idList);
		return ApiResponse.ok(flag);
	}

	@PostMapping("/disease-save")
	@ResponseBody
	public Response diseaseSave(Disease disease) {
		boolean flag = diseaseService.saveOrUpdate(disease);
		return ApiResponse.ok(flag);
	}

	@GetMapping("/hello")
	@ResponseBody
	@ApiOperation(value = "返回请求信息", notes = "根据请求参数，返回请求信息")
	@ApiImplicitParam(name = "name", value = "名字", defaultValue = "swagger")
	public Response hello(@RequestParam(value = "name", defaultValue = "swagger") String name) {
		return ApiResponse.ok("hello：" + name + "！");
	}

	@GetMapping("/getById")
	@ResponseBody
	@ApiOperation(value = "根据id查询", notes = "获取所有信息")
	@ApiImplicitParam(name = "id", value = "主键名字", defaultValue = "1")
	public Response getById(Integer id) {
		return ApiResponse.ok(diseaseService.getById(id));
	}

	@GetMapping("/getAll")
	@ResponseBody
	@ApiOperation(value = "查询所有", notes = "获取所有信息")
	public Response getAll() {
		return ApiResponse.ok(diseaseService.list());
	}

	@GetMapping("/getByPage")
	@ResponseBody
	@ApiOperation(value = "分页查询所有", notes = "获取所有信息")
	public Response getByPage() {
		Page<Disease> page = new Page<Disease>(1, 10);
		page.addOrder(OrderItem.descs("create_time"));
		return ApiResponse.ok(diseaseService.page(page));
	}
}
