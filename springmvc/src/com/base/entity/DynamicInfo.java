package com.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="app_user_info")
public class DynamicInfo implements java.io.Serializable{
	private String id;//主键
	private String publishUserId;//发布用户id
	private String publishType;//默认0个人，1企业
	private String publishTime;//发布时间
	private String category;//分类
	private String content;//内容
}
