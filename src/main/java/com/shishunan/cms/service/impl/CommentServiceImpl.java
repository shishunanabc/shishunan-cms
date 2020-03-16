package com.shishunan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.cms.dao.CommentDao;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.entity.Comment;
import com.shishunan.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao dao;

	public int insert(Comment comment) {
		return dao.insert(comment);
	}

	public List<Comment> selects(Article article) {
		return dao.selects(article);
	}

}
