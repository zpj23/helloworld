package com.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_user_info")
public class AppUserInfo implements java.io.Serializable {
	private String id;//主键id
	private int sex;//默认0男，1女
	private String phone;//手机号码
	private String password;//密码
	private String company;//公司
	private String position;//职位
	private String primarySchool;//小学
	private String juniorHighSchool;//初中
	private String seniorHighSchool;//高中
	private String university;//大学
	private String signature;//签名
	private String portrait;//头像
	private float workingYear;//工作年限
	private Date birthDay;//出生年月
	private String myLocation;//定位
	private String level;//等级
	private String job;//求职状态标志
	private String isV;//是否加V标志
	
	
	@Id @Column(length=36,nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPrimarySchool() {
		return primarySchool;
	}
	public void setPrimarySchool(String primarySchool) {
		this.primarySchool = primarySchool;
	}
	public String getJuniorHighSchool() {
		return juniorHighSchool;
	}
	public void setJuniorHighSchool(String juniorHighSchool) {
		this.juniorHighSchool = juniorHighSchool;
	}
	public String getSeniorHighSchool() {
		return seniorHighSchool;
	}
	public void setSeniorHighSchool(String seniorHighSchool) {
		this.seniorHighSchool = seniorHighSchool;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public float getWorkingYear() {
		return workingYear;
	}
	public void setWorkingYear(float workingYear) {
		this.workingYear = workingYear;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(String myLocation) {
		this.myLocation = myLocation;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIsV() {
		return isV;
	}
	public void setIsV(String isV) {
		this.isV = isV;
	}
	
	
	
}
