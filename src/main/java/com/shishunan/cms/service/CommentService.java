package com.shishunan.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.entity.Comment;

public interface CommentService {

	

	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据文章查询文章评论
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> selects(Article article);
}
