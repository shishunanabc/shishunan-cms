package com.shishunan.cms.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.shishunan.cms.entity.Article;
import com.shishunan.cms.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	@Autowired
	private ArticleService service;
	
	@Test
	public void testInsert() {
		Article article = new Article();
		article.setTitle("test");
		article.setUserId(1);
		article.setChannelId(1);
		article.setCategoryId(1);
		article.setContent("aaaaaaaaaaaaaaaaaaaa");
		article.setCreated(new Date());
		
		service.insert(article);
	}

	@Test
	public void testSelects(Article article) {
		PageInfo<Article> info = (PageInfo<Article>) service.selects(article);
		System.out.println(info.getList());
	}
}
