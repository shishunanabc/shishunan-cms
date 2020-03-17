package com.shishunan.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.shishunan.cms.entity.Article;

public interface ArticleDao {

	List<Article> selects(Article article);

	int insert(Article article);

	Article cha(@Param("idd")Integer id);

	List<Article> selec(Article article);

	int upda(@Param("idd")Integer id);

	int upd(@Param("idd")Integer id);

	int pass(@Param("idd")Integer id);

	int pas(@Param("idd")Integer id);

	Article show(Article article);

	List<Article> select(Article article);

	List<Article> coCount();
	@Update("update cms_article set cocount=cocount+1 where id=#{idd}")
	void commentCount(@Param("idd")Integer articleId);
	//添加点击量
	int click(@Param("idd")Integer id);

	
}
