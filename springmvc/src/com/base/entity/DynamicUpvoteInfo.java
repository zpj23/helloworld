package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 动态点赞表
 * @ClassName: DynamicUpvoteInfo
 * @author zpj 
 * @date 2017-12-19 上午11:24:44
 *
 */
@Entity
@Table(name="app_dynamic_upvote_info")
public class DynamicUpvoteInfo implements java.io.Serializable {
	private String id;
	private String dynamicId;//动态表id
	private String userId;//
	private String upvoteType;//默认0个人，1企业
	private String createTime;//创建时间
	@Id @Column(length=36,nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpvoteType() {
		return upvoteType;
	}
	public void setUpvoteType(String upvoteType) {
		this.upvoteType = upvoteType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
