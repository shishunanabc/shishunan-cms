package com.shishunan.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishunan.cms.dao.SlideDao;
import com.shishunan.cms.entity.Slide;
import com.shishunan.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService{

	@Autowired
	private SlideDao dao;

	public List<Slide> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}
}
