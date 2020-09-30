package com.ghq.pig.farm.feeding.controller;

import java.time.LocalDateTime;
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

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ghq.pig.farm.common.ApiResponse;
import com.ghq.pig.farm.common.Response;
import com.ghq.pig.farm.feeding.entity.Feeding;
import com.ghq.pig.farm.feeding.service.IFeedingService;

/**
 * <p>
 * 饲养管理控制器
 * </p>
 *
 * @author GHQ
 * @since 2020-09-29
 */
@Controller
@RequestMapping("/feeding")
public class FeedingController {

	@Autowired
	private IFeedingService feedingService;

	@GetMapping("list")
	@ResponseBody
	public ModelAndView list() {
		return new ModelAndView("feeding/feeding-list");
	}

	@GetMapping("/view")
	public ModelAndView view(String name) {
		List<Feeding> list = feedingService.list(Wrappers.lambdaQuery(Feeding.class).eq(Feeding::getName, name));
		return new ModelAndView("feeding/feeding-view").addObject("list", list);
	}

	@GetMapping("page")
	@ResponseBody
	public Response page(@RequestParam("page") Long current, @RequestParam("limit") Long pageSize) {
		Page<Feeding> page = new Page<Feeding>(current, pageSize);
		page = feedingService.page(page);
		return ApiResponse.ok(page);
	}

	@GetMapping("/save")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView("feeding/feeding-save");
		if (id != null && id > 0) {
			Feeding feeding = feedingService.getById(id);
			return modelAndView.addObject("feeding", feeding);
		}
		return modelAndView;
	}

	@PostMapping("/del")
	@ResponseBody
	public Response del(@NotBlank(message = "ids不能为空") String ids) {
		List<Integer> idList = Stream.of(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
		boolean flag = feedingService.removeByIds(idList);
		return ApiResponse.ok(flag);
	}

	@PostMapping("/save")
	@ResponseBody
	public Response feedingSave(Feeding feeding) {
		feeding.setCreateTime(LocalDateTime.now());
		boolean flag = feedingService.saveOrUpdate(feeding);
		return ApiResponse.ok(flag);
	}
}
