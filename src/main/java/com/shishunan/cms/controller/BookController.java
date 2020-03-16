package com.shishunan.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	@RequestMapping("bootstrap")
	public String bootstap() {
		
		return "bootstrap";
	}

	//三栏
	
	@RequestMapping("bootstrap3")
	public String bootstap3() {
		
		return "bootstrap3";
	}
}
