package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @Description: 用户好友表
 * @ClassName: UserFriendInfo
 * @author zpj 
 * @date 2017-12-19 上午11:23:41
 *
 */
@Entity
@Table(name="app_friend_info")
public class UserFriendInfo implements java.io.Serializable {
	private String id;
	private String userId;//主用户id
	private String friendId;//朋友id
	private String createTime;//创建时间
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
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
