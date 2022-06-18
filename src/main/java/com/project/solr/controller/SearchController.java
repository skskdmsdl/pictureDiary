package com.project.solr.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.project.solr.common.SearchEngine;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping("/searchList.do")
	public ModelAndView SearchList(ModelAndView mav,  HttpSession session, @RequestParam(required=false, defaultValue="*") String word) throws Exception {
		int userId = (int)session.getAttribute("userId");
		String encodeResult = URLEncoder.encode(word, "UTF-8");
		
		SearchEngine se = new SearchEngine();
//		String url = "http://localhost:8983/solr/solrProject/select?fq=title:"+encodeResult+"&fq=content:"+encodeResult+"&q=user_id:"+userId+"&sort=diary_date%20desc,diary_id%20desc";	
		String url = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"%20content:"+encodeResult+"&q.op=OR&indent=true&sort=create_date%20desc&fq=user_id:"+userId;	
		String urlTitle = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"&q.op=OR&indent=true&sort=create_date%20desc&fq=user_id:"+userId;	
		String urlContent = "http://localhost:8983/solr/solrProject/query?q=content:"+encodeResult+"&q.op=OR&indent=true&sort=create_date%20desc&fq=user_id:"+userId;	
		System.out.println("url : "+url);
		
		Map<String, Object> map = se.process(url);
		Map<String, Object> titleMap = se.process(urlTitle);
		Map<String, Object> contentMap = se.process(urlContent);
		
		mav.addObject("qTime", map.get("qTime"));
		mav.addObject("totalCount", map.get("totalCount"));
		mav.addObject("searchList", map.get("searchList"));
		mav.addObject("titleSearchList", titleMap.get("searchList"));
		mav.addObject("contentSearchList", contentMap.get("searchList"));

		mav.setViewName("search/searchList");

		return mav;
	}
	
	private String[] keywords = { "Kim GilDong", "Kim NaRi", "Kim GilSu", "Kim Angel" };

	@SuppressWarnings("unchecked")
	private List<String> search(String keyword) {
		if (keyword == null || keyword.equals(""))
			return java.util.Collections.EMPTY_LIST;
		keyword = keyword.toUpperCase();
		List<String> result = new ArrayList<String>(8);
		for (int i = 0; i < keywords.length; i++) {
			if (((String) keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/autoComplete.do")
	@ResponseBody
	public List<String> autoComplete(@RequestParam("keyword") String keyword) throws Exception{
		
		String decode_keyword = URLDecoder.decode(keyword,"utf-8");
		List<String> keywordList = search(decode_keyword);
		
		LOGGER.debug("result >" + keywordList.toString());
		
		return keywordList;
	}

}