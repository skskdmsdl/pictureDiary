package com.project.solr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/write")
public class WriteController {

	@RequestMapping("/write.do")
	public String Write() throws Exception {
		return "write/write";
	}

}
