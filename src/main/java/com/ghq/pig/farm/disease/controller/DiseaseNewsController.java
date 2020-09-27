package com.ghq.pig.farm.disease.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ghq.pig.farm.common.ApiResponse;
import com.ghq.pig.farm.common.Response;
import com.ghq.pig.farm.disease.entity.DiseaseNews;
import com.ghq.pig.farm.disease.service.IDiseaseNewsService;

import io.swagger.annotations.Api;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author GHQ
 * @since 2020-09-27
 */
@RestController
@RequestMapping("/disease/disease-news")
@Api(tags = { "猪病新闻" })
public class DiseaseNewsController {

	@Autowired
	private IDiseaseNewsService diseaseNewsService;

	@GetMapping("/disease-news-list")
	@ResponseBody
	public ModelAndView list() {
		return new ModelAndView("disease/disease-news/disease-news-list");
	}

	@GetMapping("/disease-news-page")
	@ResponseBody
	public Response page(@RequestParam("page") Long current, @RequestParam("limit") Long pageSize) {
		Page<DiseaseNews> page = new Page<DiseaseNews>(current, pageSize);
		page.addOrder(OrderItem.descs("create_time"));
		page = diseaseNewsService.page(page);
		return ApiResponse.ok(page);
	}

	@GetMapping("/disease-news-save")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView("disease/disease-news/disease-news-save");
		if (id != null && id > 0) {
			DiseaseNews diseaseNews = diseaseNewsService.getById(id);
			return modelAndView.addObject("diseaseNews", diseaseNews);
		}
		return modelAndView;
	}

	@GetMapping("/disease-news-view")
	public ModelAndView view() {
		return new ModelAndView("disease/disease-news/disease-news-view");
	}

	@PostMapping("/disease-news-del")
	@ResponseBody
	public Response del(@NotBlank(message = "ids不能为空") String ids) {
		List<Integer> idList = Stream.of(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
		boolean flag = diseaseNewsService.removeByIds(idList);
		return ApiResponse.ok(flag);
	}

	@PostMapping("/disease-news-save")
	@ResponseBody
	public Response diseaseSave(DiseaseNews diseaseNews) {
		boolean flag = diseaseNewsService.saveOrUpdate(diseaseNews);
		return ApiResponse.ok(flag);
	}
}
