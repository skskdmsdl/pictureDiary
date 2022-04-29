package com.project.solr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@RequestMapping("/detail.do")
	public String Detail() throws Exception {
		return "diary/detail";
	}

}