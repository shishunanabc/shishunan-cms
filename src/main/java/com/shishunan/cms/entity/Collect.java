package com.shishunan.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: Collect 
 * @Description: 文章的收集
 * @author: charles
 * @date: 2020年2月15日 上午8:41:22
 */
public class Collect  implements Serializable{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String text;//文章的标题
	private String url;//文章的url
	private  Integer userId;//收藏人
	private Date created;//收藏时间
	public Collect() {
		super();
	}
	public Collect(Integer id, String text, String url, Integer userId, Date created) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.userId = userId;
		this.created = created;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", text=" + text + ", url=" + url + ", userId=" + userId + ", created=" + created
				+ "]";
	}
	

}
