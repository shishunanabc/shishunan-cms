package com.shishunan.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.entity.User;
import com.shishunan.cms.service.ArticleService;
import com.shishunan.cms.service.UserService;
@RequestMapping("admin")
@Controller
public class AdminController {

	@Autowired
	private ArticleService service;
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value = {"","/","admin"})
	public String admin() {
		return "admin/index";
	}
	
	@RequestMapping("articles")
	public String articles(Article article,Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 3);
		List<Article> list=service.selec(article);
		PageInfo<Article> page1=new PageInfo<Article>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", page1);
		return "admin/articles";
	}
	
	@RequestMapping("upda")
	@ResponseBody
	public int upda(Integer id) {
		return service.upda(id);
	}
	
	@RequestMapping("upd")
	@ResponseBody
	public int upd(Integer id) {
		return service.upd(id);
	}
	
	@RequestMapping("pass")
	@ResponseBody
	public int pass(Integer id) {
		return service.pass(id);
	}
	
	@RequestMapping("pas")
	@ResponseBody
	public int pas(Integer id) {
		return service.pas(id);
	}

	@RequestMapping("user")
	public String users(User user,Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 3);
		List<User> list=uservice.select1(user);
		PageInfo<User> page1=new PageInfo<User>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", page1);
		m.addAttribute("us", user);
		return "admin/user";
	}
	
	@RequestMapping("up")
	@ResponseBody
	public int up(Integer id) {
		return uservice.up(id);
	}
	
	@RequestMapping("u")
	@ResponseBody
	public int u(Integer id) {
		return uservice.u(id);
	}
}
