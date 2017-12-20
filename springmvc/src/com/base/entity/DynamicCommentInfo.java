package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 动态评论表
 * @ClassName: DynamicCommentInfo
 * @author zpj 
 * @date 2017-12-19 上午11:24:20
 *
 */
@Entity
@Table(name="app_dynamic_comment_info")
public class DynamicCommentInfo implements java.io.Serializable{
	private String id;//主键
	private String dynamicId;//动态表id
	private String commentUserId;//评论人id
	private String commentType;//评论类型//默认0个人，1企业
	private String commentContent;//评论人内容
	private String createTime;//创建时间
	private String referUserId;//提及人员id,多个用逗号分割
	private String referUserName;//提及人员名称
	private int isShow;//是否显示 默认1显示，0不显示
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
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReferUserId() {
		return referUserId;
	}
	public void setReferUserId(String referUserId) {
		this.referUserId = referUserId;
	}
	public String getReferUserName() {
		return referUserName;
	}
	public void setReferUserName(String referUserName) {
		this.referUserName = referUserName;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	
	
}
