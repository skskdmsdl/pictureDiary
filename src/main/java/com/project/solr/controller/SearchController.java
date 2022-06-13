package com.project.solr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.common.SearchEngine;

@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping("/searchList.do")
	public ModelAndView SearchList(ModelAndView mav,  HttpSession session) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int userId = (int)session.getAttribute("userId");
		
		SearchEngine se = new SearchEngine();
		String url = "http://localhost:8983/solr/solrProject/select?q=user_id:"+userId;
		
		Map<String, Object> map = se.process(url);
		
		mav.addObject("qTime", map.get("qTime"));
		mav.addObject("totalCount", map.get("totalCount"));
		mav.addObject("searchList", map.get("searchList"));

		mav.setViewName("search/searchList");

		return mav;
	}

}