package com.sys.dao;

import java.util.List;

import com.sys.entity.DepartmentRoleInfo;


public interface RoleDepartmentDao {
	public  void delDepartmentRoleByRoleId(int id);
	
	public void saveDepartmentRole(DepartmentRoleInfo d);
	
	public List<Object[]> findDepartmentRoleByRoleId(int roleid);
	
	public List<Object[]> findRoleIdByDepartmentId(int departmentid);
}
