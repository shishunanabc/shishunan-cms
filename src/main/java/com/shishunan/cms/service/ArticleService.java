package com.shishunan.cms.service;

import java.util.List;

import com.shishunan.cms.entity.Article;

public interface ArticleService {
	//查询
	List<Article> selects(Article article);
	//添加
	int insert(Article article);
	Article cha(Integer id);
	List<Article> selec(Article article);
	int upda(Integer id);
	int upd(Integer id);
	int pass(Integer id);
	int pas(Integer id);
	Article show(Article article);
	List<Article> select(Article article);
	List<Article> coCount();
	void commentCount(Integer articleId);
	//添加点击量
	int click(Integer id);
}
