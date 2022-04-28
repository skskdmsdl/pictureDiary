package com.project.solr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping("/searchList.do")
	public String SearchList() throws Exception {
		return "search/searchList";
	}

}