package com.shishunan.cms.service;

import java.util.List;

import com.shishunan.cms.entity.Category;
import com.shishunan.cms.entity.Channel;

public interface ChannelService {

	List<Channel> selects();

	List<Category> sele(Integer channelId);

}
