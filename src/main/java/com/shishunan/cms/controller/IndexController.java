package com.shishunan.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.entity.Category;
import com.shishunan.cms.entity.Channel;
import com.shishunan.cms.entity.Collect;
import com.shishunan.cms.entity.Comment;
import com.shishunan.cms.entity.Slide;
import com.shishunan.cms.entity.User;
import com.shishunan.cms.service.ArticleService;
import com.shishunan.cms.service.ChannelService;
import com.shishunan.cms.service.CollectService;
import com.shishunan.cms.service.CommentService;
import com.shishunan.cms.service.SlideService;

@Controller
public class IndexController {

	@Autowired
	private ChannelService service;
	@Autowired
	private ArticleService service2;
	@Autowired
	private SlideService service3;
	@Autowired
	private CommentService service4;
	@Autowired
	private CollectService service5;
	@RequestMapping(value = {"","/","index"})
	public String index(Model m,Article article,@RequestParam(defaultValue = "1")int page) {
		List<Channel> selects=service.selects();
		if (article.getChannelId()!=null) {
			List<Category> sele = service.sele(article.getChannelId());
			m.addAttribute("categorys", sele);
		}
		List<Slide> li=service3.select();
		PageHelper.startPage(page, 2);
		List<Article> selec = service2.selec(article);
		PageInfo<Article> pa=new PageInfo<Article>(selec);
		List<Article> select2=service2.select(new Article());
		m.addAttribute("g", selec);
		m.addAttribute("channels", selects);
		m.addAttribute("info", pa);
		m.addAttribute("li", li);
		m.addAttribute("ss", select2);
		return "index/index";
	}
	
	@RequestMapping("show")
	public String show(Article article,Model m,@RequestParam(defaultValue = "1")int page,HttpSession session) {
		List<Comment> list=service4.selects(article);
		Article show=service2.show(article);
		//分页
		PageHelper.startPage(page, 5);
		//查询评论数
		List<Article> lis=service2.coCount();
		//分页
		PageInfo<Article> pages=new PageInfo<Article>(lis);
		//获取session
		User user = (User) session.getAttribute("user");
		Collect collect=null;
		if (user!=null) {//判断是否登陆状态，才能查询是否收藏
			collect=service5.selectByTitleAndUserId(show.getTitle(), user.getId());
		}
		m.addAttribute("g", show);
		m.addAttribute("list", list);
		m.addAttribute("ss", lis);
		m.addAttribute("co", collect);
		return "index/show";
	}
	
	@RequestMapping("collect")
	@ResponseBody
	public int collect(Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user==null) {
			return 0;
		}
		collect.setUserId(user.getId());
		collect.setCreated(new Date());
		
		return service5.insert(collect);
	}
	
	@RequestMapping("deleteCollect")
	@ResponseBody
	public int deleteCollect(Integer id) {
		return service5.delete(id);
	}
}
