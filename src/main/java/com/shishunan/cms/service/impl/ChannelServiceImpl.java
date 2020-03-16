package com.shishunan.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishunan.cms.dao.ChannelDao;
import com.shishunan.cms.entity.Category;
import com.shishunan.cms.entity.Channel;
import com.shishunan.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	private ChannelDao cdao;

	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return cdao.selects();
	}

	public List<Category> sele(Integer channelId) {
		// TODO Auto-generated method stub
		return cdao.sele(channelId);
	}
}
