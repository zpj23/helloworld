package com.base.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Description: 简历表
 * @ClassName: ResumeInfo
 * @author zpj 
 * @date 2017-12-19 上午11:41:20
 *
 */
@Entity
@Table(name="app_resume_info")
public class ResumeInfo implements java.io.Serializable{
	private String id;//主键
	private String resumeName;//简历名称
	private String realName;//真实姓名
	private int sex;//默认0男，1女
	private Date birth;//出生年月
	private Date participateTime;//参加工作时间
	private String livingPlace;//县居住地
	private String phone;//手机号码
	private String email;//油箱
	
	
}
