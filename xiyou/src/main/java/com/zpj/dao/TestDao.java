package com.zpj.dao;

import com.zpj.entity.TestUser;

public interface TestDao {
	public TestUser addUser(TestUser u);
	
	public TestUser findUserInfoById(String id);
}
