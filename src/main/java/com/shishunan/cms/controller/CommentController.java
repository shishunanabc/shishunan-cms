package com.shishunan.cms.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishunan.cms.entity.Comment;
import com.shishunan.cms.entity.User;
import com.shishunan.cms.service.ArticleService;
import com.shishunan.cms.service.CommentService;
@RequestMapping("comment")
@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	@Autowired
	private ArticleService service2;
	@RequestMapping("insert")
	@ResponseBody
	public int insert(Comment comment,Integer articleId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user==null) {
			return 0;
		}else {
			comment.setUserId(user.getId());
			comment.setArticleId(articleId);
			comment.setCreated(new Date());
			service2.commentCount(articleId);
			//添加评论
			return service.insert(comment);
		}
	}
	
	
	
}
