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
@Api(tags = { "治疗方案" })
public class DiseaseController {

	@Autowired
	private IDiseaseService diseaseService;

	@GetMapping("/list")
	@ResponseBody
	public ModelAndView list() {
		return new ModelAndView("disease/disease-list");
	}

	@GetMapping("/page")
	@ResponseBody
	public Response page(@RequestParam("page") Long current, @RequestParam("limit") Long pageSize) {
		Page<Disease> page = new Page<Disease>(current, pageSize);
		page.addOrder(OrderItem.descs("create_time"));
		page = diseaseService.page(page);
		return ApiResponse.ok(page);
	}

	@GetMapping("/save")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView("disease/disease-save");
		if (id != null && id > 0) {
			Disease disease = diseaseService.getById(id);
			return modelAndView.addObject("disease", disease);
		}
		return modelAndView;
	}

	@GetMapping("/view")
	public ModelAndView view() {
		return new ModelAndView("disease/disease-view");
	}

	@PostMapping("/del")
	@ResponseBody
	public Response del(@NotBlank(message = "ids不能为空") String ids) {
		List<Integer> idList = Stream.of(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
		boolean flag = diseaseService.removeByIds(idList);
		return ApiResponse.ok(flag);
	}

	@PostMapping("/save")
	@ResponseBody
	public Response diseaseSave(Disease disease) {
		boolean flag = diseaseService.saveOrUpdate(disease);
		return ApiResponse.ok(flag);
	}
}
