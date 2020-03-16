package com.shishunan.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.entity.Category;
import com.shishunan.cms.entity.Channel;
import com.shishunan.cms.entity.Collect;
import com.shishunan.cms.entity.User;
import com.shishunan.cms.service.ArticleService;
import com.shishunan.cms.service.ChannelService;
import com.shishunan.cms.service.CollectService;
import com.shishunan.cms.service.UserService;

@RequestMapping("my")
@Controller
public class MyController {
	@Autowired
	private ArticleService service;
	@Autowired
	private ChannelService cservice;
	@Autowired
	private CollectService coservice;
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "my/index";
	}
	
	@RequestMapping("articles")
	public String articles(Article article,Model m,@RequestParam(defaultValue = "1")int pageNum,HttpSession session) {
		User user=(User) session.getAttribute("user");
		article.setUserId(user.getId());
		PageHelper.startPage(pageNum, 3);
		List<Article> list=service.selects(article);
		PageInfo<Article> page=new PageInfo<Article>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", page);
		return "my/articles";
	}
	
	@RequestMapping("public")
	public String publish() {
		return "my/publish";
	}
	
	@RequestMapping("channel")
	@ResponseBody
	public List<Channel> chann(){
		return cservice.selects();
	}
	
	@RequestMapping("categorys")
	@ResponseBody
	public List<Category> cate(Integer channelId){
		return cservice.sele(channelId);
	}
	
	@RequestMapping("fabu")
	@ResponseBody
	public int fabu(@RequestParam("file2") MultipartFile file,Article article,HttpSession session) throws Exception {
		//设置文件上传
		if (!file.isEmpty()) {
			String uploa="d:/img/";
			String filename=file.getOriginalFilename();
			String newFilename=UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			File f = new File(uploa,newFilename);
			file.transferTo(f);
			article.setPicture(newFilename);
		}
		//封装文件的基本属性
		User user=(User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setStatus(0);
		article.setHits(0);
		article.setDeleted(0);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		article.setContentType(0);
		article.setHot(0);
		return service.insert(article);
	}
	/*
	 * article.setStatus(0);//默认待审核 
	 * article.setHits(0);//默认点击量为 0
	 * article.setDeleted(0);//默认未删除 
	 * article.setCreated(new Date());//默认发布时间
	 * article.setUpdated(new Date());//默认发布时间 
	 * article.setContentType(0);//发布的文章类型
	 * article.setHot(0);//非热点
	 */
	
	@RequestMapping("articlecha")
	@ResponseBody
	public Article cha(Integer id) {
		return service.cha(id);
	}
	
	@RequestMapping("collect")
	public String collect(HttpSession session,Model m) {
		User user = (User) session.getAttribute("user");
		List<Collect> list=coservice.select(user.getId());
		m.addAttribute("g", list);
		return "my/collect";
	}
}
