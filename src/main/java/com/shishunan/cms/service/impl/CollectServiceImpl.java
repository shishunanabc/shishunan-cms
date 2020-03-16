package com.shishunan.cms.service.impl;

import java.awt.color.CMMException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishunan.cms.dao.CollectDao;
import com.shishunan.cms.entity.Collect;
import com.shishunan.cms.service.CollectService;
import com.ssn.common.utils.StringUtil;

@Service
public class CollectServiceImpl  implements CollectService{
	@Autowired
	private CollectDao dao;

	
	public int insert(Collect collect) {
		if(!StringUtil.isHttpUrl(collect.getUrl()))
			throw new CMMException("不是合法的url");
		return dao.insert(collect);
	}

	
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
	public List<Collect> selects(Integer userId) {
		// TODO Auto-generated method stub
		return dao.selects(userId);
	}

	
	public Collect selectByTitleAndUserId(String title, Integer userId) {
		// TODO Auto-generated method stub
		return dao.selectByTitleAndUserId(title, userId);
	}


	public List<Collect> select(Integer id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

}
