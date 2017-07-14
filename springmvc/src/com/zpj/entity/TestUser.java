package com.zpj.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "test_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TestUser  implements Serializable{
	private int id;//主键
	private String nick_name;//昵称
	private String client_type;//0公众号，1app
	private String phone;//手机
	private String wxunionid;//微信UnionId
	private String password;//密码
	private String sex;//0女，1男
	private String birth;//出生年月
	private int balance;//余额
	private int remain_time;//剩余时间
	private Date register_time;//注册时间
	private Date last_login_time;//上次登陆时间
	private Date update_time;//更新时间
	private String type;//用户类型   0普通用户，1物业
	private int total_charge_time;//总充电时间
	
	
	
	
	public TestUser() {
		super();
	}
	public TestUser(int id, String nick_name, String client_type, String phone,
			String wxunionid, String password, String sex, String birth,
			int balance, int remain_time, Date register_time,
			Date last_login_time, Date update_time, String type,
			int total_charge_time) {
		super();
		this.id = id;
		this.nick_name = nick_name;
		this.client_type = client_type;
		this.phone = phone;
		this.wxunionid = wxunionid;
		this.password = password;
		this.sex = sex;
		this.birth = birth;
		this.balance = balance;
		this.remain_time = remain_time;
		this.register_time = register_time;
		this.last_login_time = last_login_time;
		this.update_time = update_time;
		this.type = type;
		this.total_charge_time = total_charge_time;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id",unique=true, nullable = false, precision = 22, scale = 0)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "nick_name", length=100)
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	@Column(name = "client_type", length=10)
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	@Column(name = "phone", length=100)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "wxunionid", length=100)
	public String getWxunionid() {
		return wxunionid;
	}
	public void setWxunionid(String wxunionid) {
		this.wxunionid = wxunionid;
	}
	@Column(name = "password", length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "sex", length=10)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name = "birth", length=20)
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Column(name = "balance",precision = 22, scale = 0)
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Column(name = "remain_time",precision = 22, scale = 0)
	public int getRemain_time() {
		return remain_time;
	}
	public void setRemain_time(int remain_time) {
		this.remain_time = remain_time;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_time", length = 7)
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time", length = 7)
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	@Column(name = "type", length = 10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "total_charge_time",precision = 22, scale = 0)
	public int getTotal_charge_time() {
		return total_charge_time;
	}
	public void setTotal_charge_time(int total_charge_time) {
		this.total_charge_time = total_charge_time;
	}
	
	
	
	

}

