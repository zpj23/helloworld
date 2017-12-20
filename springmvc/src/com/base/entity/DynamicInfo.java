package com.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 动态表
 * @ClassName: DynamicInfo
 * @author zpj 
 * @date 2017-12-19 上午11:24:34
 *
 */
@Entity
@Table(name="app_dynamic_info")
public class DynamicInfo implements java.io.Serializable{
	private String id;//主键
	private String publishUserId;//发布用户id
	private String publishType;//默认0个人，1企业
	private String publishTime;//发布时间
	private String category;//分类
	private String content;//内容
	private String url;//图片链接
	private String upvoteCount;//点赞数量
	private String commentCount;//评论数量
	private int isDel;//是否删除，默认1使用中，0已删除
	private int isShow;//是否显示，默认1显示，0不显示
	private Date delTime;//删除时间
	private Date createTime;//创建时间
	
	@Id @Column(length=36,nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPublishUserId() {
		return publishUserId;
	}
	public void setPublishUserId(String publishUserId) {
		this.publishUserId = publishUserId;
	}
	public String getPublishType() {
		return publishType;
	}
	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUpvoteCount() {
		return upvoteCount;
	}
	public void setUpvoteCount(String upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public Date getDelTime() {
		return delTime;
	}
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
