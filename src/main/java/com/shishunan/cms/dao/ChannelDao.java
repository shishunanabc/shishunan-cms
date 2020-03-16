package com.shishunan.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shishunan.cms.entity.Category;
import com.shishunan.cms.entity.Channel;

public interface ChannelDao {

	List<Channel> selects();

	List<Category> sele(@Param("idd")Integer channelId);

}
