package com.zpj.service;

import com.zpj.entity.TestUser;

public interface TestService {
	public void login();
	public TestUser addUser(TestUser u);
	
	public TestUser findUserInfoById(String id);
}
