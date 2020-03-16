package com.shishunan.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.shishunan.cms.entity.User;

public interface UserDao {

	List<User> select1(User user);

	int up(@Param("idd")Integer id);

	int u(@Param("idd")Integer id);

	int login(User user);
	
	User yan(@Param("user")String user);

}
