package com.project.solr.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.common.SearchEngine;
import com.project.solr.entity.DiaryEntity;
import com.project.solr.service.DiaryService;

@Controller
@RequestMapping("/search")
public class SearchController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

	@Autowired
    private DiaryService diaryService;
	
	@RequestMapping("/searchList.do")
	public ModelAndView SearchList(ModelAndView mav, HttpSession session, @RequestParam(required=false, defaultValue="*") String word) throws Exception {
		try {
			
			int userId = (int)session.getAttribute("userId");
		}catch (Exception e){
			mav.setViewName("redirect:/");

			return mav;
		}
		word = word.replaceAll(" ", "");
		int userId = (int)session.getAttribute("userId");		
		String encodeResult = URLEncoder.encode(word, "UTF-8");
		
		SearchEngine se = new SearchEngine();
//		String url = "http://localhost:8983/solr/solrProject/select?fq=title:"+encodeResult+"&fq=content:"+encodeResult+"&q=user_id:"+userId+"&sort=diary_date%20desc,diary_id%20desc";	
		String url = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"%20content:"+encodeResult+"&q.op=OR&indent=true&rows=4&sort=create_date%20desc&fq=user_id:"+userId;	
		String urlTitle = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"&q.op=OR&indent=true&rows=4&sort=create_date%20desc&fq=user_id:"+userId;	
		String urlContent = "http://localhost:8983/solr/solrProject/query?q=content:"+encodeResult+"&q.op=OR&indent=true&rows=4&sort=create_date%20desc&fq=user_id:"+userId;	
		System.out.println("url : "+url);
		
		Map<String, Object> map = se.process(url);
		Map<String, Object> titleMap = se.process(urlTitle);
		Map<String, Object> contentMap = se.process(urlContent);
		
		mav.addObject("qTime", map.get("qTime"));
		mav.addObject("totalCount", map.get("totalCount"));
		mav.addObject("searchList", map.get("searchList"));
		mav.addObject("titleSearchList", titleMap.get("searchList"));
		mav.addObject("contentSearchList", contentMap.get("searchList"));
		System.out.println(map.get("searchList"));
		mav.setViewName("search/searchList");
		
		return mav;
	}
	
	@RequestMapping("/addSearchList.do")
	@ResponseBody
	public List<Object> AddSearchList(@RequestParam Map<String, String> params, HttpSession session, @RequestParam(required=false, defaultValue="*") String word) throws Exception {
		
		List<Object> searchList = new ArrayList<>();
		int userId = (int)session.getAttribute("userId");		
		String filter = params.get("filter");
		String listCount = params.get("listCount");
		String encodeResult = URLEncoder.encode(word, "UTF-8");
		String url = null;
		
		SearchEngine se = new SearchEngine();

		if(filter.equals("titleFilter")) {
			url = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"&q.op=OR&indent=true&rows="+listCount+"&sort=create_date%20desc&fq=user_id:"+userId;	
		}else if(filter.equals("contentFilter")) {
			url = "http://localhost:8983/solr/solrProject/query?q=content:"+encodeResult+"&q.op=OR&indent=true&rows="+listCount+"&sort=create_date%20desc&fq=user_id:"+userId;	
		}else {
			url = "http://localhost:8983/solr/solrProject/query?q=title:"+encodeResult+"%20content:"+encodeResult+"&q.op=OR&indent=true&rows="+listCount+"&sort=create_date%20desc&fq=user_id:"+userId;	
		}
		Map<String, Object> map = se.process(url);
		searchList.add(map.get("searchList"));
		
		return searchList;
	}
	
	private List<String> search(int userId, String keyword) {
		List<DiaryEntity> diaryList = diaryService.autocomplete(userId, keyword);
		List<String> resultList = new ArrayList<>();
		for(DiaryEntity diary : diaryList){
			String title = diary.getTitle();
			String content = diary.getContent();
			if(title.contains(keyword)) {
				resultList.add(title);
			}
			if(content.contains(keyword)) {
				resultList.add(content);
			}
		}
		Set<String> removeList = new HashSet<>(resultList);
		List<String> result = new ArrayList<>(removeList);
		
		return result;
	}
	
	@RequestMapping(value = "/autoComplete.do")
	@ResponseBody
	public List<String> autoComplete(@RequestParam("keyword") String keyword, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");

		String decode_keyword = URLDecoder.decode(keyword,"utf-8");
		List<String> keywordList = search(userId, decode_keyword);
		
		LOGGER.debug("result >" + keywordList.toString());
		
		return keywordList;
	}

}