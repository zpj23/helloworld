package com.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.common.BaseDao;
import com.sys.dao.RoleUserDao;
import com.sys.entity.UserRoleInfo;

@Repository
public class RoleUserDaoImpl extends  BaseDao<UserRoleInfo> implements RoleUserDao {

	@Override
	public void delUserRoleByRoleId(int roleid) {
		String sql="delete from jl_user_role_info where roleid="+roleid;
		this.executeUpdateOrDelete(sql);
	}

	@Override
	public void saveUserRole(UserRoleInfo u) {
		this.saveOrUpdate(u);
	}

	@Override
	public List<Object[]> findUserRoleByRoleId(int roleid) {
		String sql="select userid,roleid,id from jl_user_role_info where roleid="+roleid ;
		return this.findBySql2(sql);
	}

	public List<Object[]> findRoleIdByUserId(int userid){
		String sql="select ro.id,ro.rolecode,ro.rolename from jl_user_role_info ur left join jl_role_info ro on ur.roleid=ro.id where  ur.userid="+userid ;
		return this.findBySql2(sql);
	}
}
