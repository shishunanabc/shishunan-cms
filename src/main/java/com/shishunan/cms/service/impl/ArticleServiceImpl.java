package com.shishunan.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishunan.cms.dao.ArticleDao;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao dao;

	public List<Article> selects(Article article) {
		// TODO Auto-generated method stub
		return dao.selects(article);
	}

	public int insert(Article article) {
		// TODO Auto-generated method stub
		return dao.insert(article);
	}

	public Article cha(Integer id) {
		// TODO Auto-generated method stub
		return dao.cha(id);
	}

	public List<Article> selec(Article article) {
		// TODO Auto-generated method stub
		return dao.selec(article);
	}

	public int upda(Integer id) {
		// TODO Auto-generated method stub
		return dao.upda(id);
	}

	public int upd(Integer id) {
		// TODO Auto-generated method stub
		return dao.upd(id);
	}

	public int pass(Integer id) {
		// TODO Auto-generated method stub
		return dao.pass(id);
	}

	public int pas(Integer id) {
		// TODO Auto-generated method stub
		return dao.pas(id);
	}

	public Article show(Article article) {
		// TODO Auto-generated method stub
		return dao.show(article);
	}

	public List<Article> select(Article article) {
		// TODO Auto-generated method stub
		return dao.select(article);
	}

	public List<Article> coCount() {
		// TODO Auto-generated method stub
		return dao.coCount();
	}

	public void commentCount(Integer articleId) {
		// TODO Auto-generated method stub
		dao.commentCount(articleId);
	}
	
	
}
