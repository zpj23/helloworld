package com.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:申请好友表
 * @ClassName: ApplyFriendInfo
 * @author zpj 
 * @date 2017-12-19 上午11:23:58
 *
 */
@Entity
@Table(name="app_apply_friend_info")
public class ApplyFriendInfo implements java.io.Serializable{
	private String id;
	private String userId;//用户id
	private String applyUserId;//申请人id
	private Date applyTime;//申请时间；
	private String dealResult;//处理结果 0接受，1拒绝
	private Date dealTime;//处理时间 
	@Id @Column(length=36,nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApplyUserId() {
		return applyUserId;
	}
	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	
}
