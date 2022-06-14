package com.project.solr.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.common.SearchEngine;

@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping("/searchList.do")
	public ModelAndView SearchList(ModelAndView mav,  HttpSession session, @RequestParam(required=false, defaultValue="*") String word) throws Exception {
		int userId = (int)session.getAttribute("userId");
		String encodeResult = URLEncoder.encode(word, "UTF-8");
		
		SearchEngine se = new SearchEngine();
		String url = "http://localhost:8983/solr/solrProject/select?fq=title:"+encodeResult+"&fq=content:"+encodeResult+"&q=user_id:"+userId+"&sort=diary_date%20desc,diary_id%20desc";	
		
		Map<String, Object> map = se.process(url);
		
		mav.addObject("qTime", map.get("qTime"));
		mav.addObject("totalCount", map.get("totalCount"));
		mav.addObject("searchList", map.get("searchList"));

		mav.setViewName("search/searchList");

		return mav;
	}

}