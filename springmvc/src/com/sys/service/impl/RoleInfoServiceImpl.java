package com.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aop.AopMethod;
import com.sys.dao.DepartmentInfoDao;
import com.sys.dao.RoleDepartmentDao;
import com.sys.dao.RoleInfoDao;
import com.sys.dao.RoleMenuDao;
import com.sys.dao.RoleUserDao;
import com.sys.dao.UserInfoDao;
import com.sys.entity.DepartmentInfo;
import com.sys.entity.DepartmentRoleInfo;
import com.sys.entity.MenuRoleInfo;
import com.sys.entity.RoleInfo;
import com.sys.entity.UserInfo;
import com.sys.entity.UserRoleInfo;
import com.sys.service.RoleInfoService;

@Service
@Component("jlRoleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoDao roleInfoDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
	private RoleUserDao roleUserDao;
	@Autowired
	private RoleDepartmentDao roleDepartmentDao;
	@Autowired
	private DepartmentInfoDao departmentDao;
	@Autowired
	private UserInfoDao userDao;
	
	@Override
	public RoleInfo findById(int id) {
		
		return roleInfoDao.findById(id);
	}

	@AopMethod(remark="保存角色信息",type="新增/编辑")
	public int saveRole(RoleInfo ri) {
		return roleInfoDao.saveRole(ri);
	}

	@Override
	public Map findList(UserInfo user, int page, int rows,
			Map<String, String> param) {
		List list=roleInfoDao.findList(user,page,rows,param);
		int count=roleInfoDao.findCount(user,param); 
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		return map;
	}

	@AopMethod(remark="保存角色_菜单信息",type="新增/编辑")
	public void saveRoleMenu(int rid,String mids){
		if(mids==null||mids.equalsIgnoreCase("")){
			//删除所有该角色关联的菜单在存入
			roleMenuDao.delMenuRoleByRoleId(rid);
			return;
		}
		String[] mid= mids.split(",");
		//先删除所有该角色关联的菜单在存入
		roleMenuDao.delMenuRoleByRoleId(rid);
		for(int m=0;m<mid.length;m++){
			int menuid=Integer.parseInt(mid[m]);
			MenuRoleInfo mri=new MenuRoleInfo(0,menuid,rid);
			roleMenuDao.saveMenuRole(mri);
		}
	}
	
	public String findRoleMenuByRoleId(int rid){
		List<Object[]> list=roleMenuDao.findMenuRoleByRoleId(rid);
		StringBuffer retStr=new StringBuffer(50);
		for(int i=0;i<list.size();i++){
			if(i>0){
				retStr.append(",");
			}
			retStr.append(list.get(i)[0]);
		}
		return retStr.toString();
	}
	@AopMethod(remark="删除角色信息",type="删除")
	public void delRole(int id){
		roleMenuDao.delMenuRoleByRoleId(id);//删除角色对应菜单关联信息
		roleUserDao.delUserRoleByRoleId(id);//删除角色对应用户的关联信息
		roleDepartmentDao.delDepartmentRoleByRoleId(id);//删除角色对应部门的关联信息
		roleInfoDao.delRoleByRoleId(id);//删除角色对应信息
	}

	@AopMethod(remark="保存角色_用户信息",type="新增/编辑")
	public void saveRoleUser(int rid, String users) {
		if(users==null||users.equalsIgnoreCase("")){
			//删除所有该角色关联的用户在存入
			roleUserDao.delUserRoleByRoleId(rid);
			return;
		}
		String[] mid= users.split(",");
		//先删除所有该角色关联的用户在存入
		roleUserDao.delUserRoleByRoleId(rid);
		for(int m=0;m<mid.length;m++){
			int menuid=Integer.parseInt(mid[m]);
			UserRoleInfo mri=new UserRoleInfo(0,menuid,rid);
			roleUserDao.saveUserRole(mri);
		}
	}

	@AopMethod(remark="保存角色_部门信息",type="新增/编辑")
	public void saveRoleDepartment(int rid, String departments) {
		if(departments==null||"".equalsIgnoreCase(departments)){
			//删除所有该角色关联的部门在存入
			roleDepartmentDao.delDepartmentRoleByRoleId(rid);
			return;
		}
		String[] mid= departments.split(",");
		//先删除所有该角色关联的部门在存入
		roleDepartmentDao.delDepartmentRoleByRoleId(rid);
		for(int m=0;m<mid.length;m++){
			int menuid=Integer.parseInt(mid[m]);
			DepartmentRoleInfo mri=new DepartmentRoleInfo(0,menuid,rid);
			roleDepartmentDao.saveDepartmentRole(mri);
		}
	}

	@Override
	public String findRoleUserByRoleId(int rid) {
		List<Object[]> list=roleUserDao.findUserRoleByRoleId(rid);
		StringBuffer retStr=new StringBuffer("");
		StringBuffer rename=new StringBuffer("");
		for(int i=0;i<list.size();i++){
			if(i>0){
				retStr.append(",");
				rename.append(",");
			}
			retStr.append(list.get(i)[0]+"");
			UserInfo ui = userDao.findById((Integer)list.get(i)[0]);
			rename.append(ui.getUsername());
		}
		if(retStr.toString().equalsIgnoreCase("")){
			retStr.append("null");
			rename.append("null");
		}
		return retStr.toString()+"*"+rename.toString();
	}

	@Override
	public String findRoleDepartmentByRoleId(int rid) {
		List<Object[]> list=roleDepartmentDao.findDepartmentRoleByRoleId(rid);
		StringBuffer retStr=new StringBuffer("");
		StringBuffer rename=new StringBuffer("");
		for(int i=0;i<list.size();i++){
			if(i>0){
				retStr.append(",");
				rename.append(",");
			}
			retStr.append(list.get(i)[0]+"");
			DepartmentInfo dp= departmentDao.findById((Integer)list.get(i)[0]);
			rename.append(dp.getName());
		}
		if(retStr.toString().equalsIgnoreCase("")){
			retStr.append("null");
			rename.append("null");
		}
		return retStr.toString()+"*"+rename.toString();
	}
	
	public List<Object[]> findRoleIdByUserId(int userid){
		return roleUserDao.findRoleIdByUserId(userid);
	}
	
	public List<Object[]> findRoleIdByDepartmentId(int deparmentid){
		return roleDepartmentDao.findRoleIdByDepartmentId(deparmentid);
	}
}
