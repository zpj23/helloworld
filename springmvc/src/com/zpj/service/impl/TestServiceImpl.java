package com.zpj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpj.dao.TestDao;
import com.zpj.entity.TestUser;
import com.zpj.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TestUser addUser(TestUser u) {
		return testDao.addUser(u);
	}

	@Override
	public TestUser findUserInfoById(String id) {
		return testDao.findUserInfoById(id);
	}
}
