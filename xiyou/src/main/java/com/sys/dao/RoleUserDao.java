package com.sys.dao;

import java.util.List;

import com.sys.entity.UserRoleInfo;


public interface RoleUserDao {
	public void delUserRoleByRoleId(int roleid);
	
	public void saveUserRole(UserRoleInfo u);
	
	public List<Object[]> findUserRoleByRoleId(int roleid);
	
	
	List<Object[]> findRoleIdByUserId(int userid);
}
