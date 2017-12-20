package com.zpj.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.common.BaseDao;
import com.zpj.dao.TestDao;
import com.zpj.entity.TestUser;
@Repository("testDao")
public class TestDaoImpl extends BaseDao<TestUser> implements TestDao{
	public TestUser addUser(TestUser u){
		this.save(u);
		return null;
	}
	
	public TestUser findUserInfoById(String id){
		String hql = " from TestUser where id ='"+id+"' or phone='"+id+"'";
		List<TestUser> list = this.findObjectByHql(hql);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
