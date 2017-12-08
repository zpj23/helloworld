package com.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.BaseController;
import com.sys.entity.UserInfo;
import com.sys.service.DepartmentInfoService;
import com.zpj.entity.TestUser;
import com.zpj.util.JSONConfig;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController{
	public UserInfo user;
	@Autowired
	public DepartmentInfoService jlDepartmentInfoService;
	
	
	@RequestMapping(value = "/getDep" ,method = RequestMethod.GET ,produces = {MediaType.APPLICATION_JSON,"application/json;charset=UTF-8"}) 
	@ResponseBody
	public JSONObject jlDepartmentInfoAction_getDep(){
//		JSONArray 
		user = (UserInfo)request.getSession().getAttribute("jluserinfo");
		Map<String,String> param=new HashMap<String,String>();
		JSONObject json = null;
		JsonConfig jsonConfig = JSONConfig.getConfig();
//		jlDepartmentInfoService.findList(user,page,rows,param)
//		TestUser u=testService.findUserInfoById(id);
		jsonConfig.setExcludes(new String[]{""});
//		json = JSONObject.fromObject(u,jsonConfig);
		return json;
//		String name=request.getParameter("username");//用户名称
////		String tpage=request.getParameter("page");
////		String trows=request.getParameter("rows");
////		if(null!=tpage&&!"".equalsIgnoreCase(tpage)){
////			page=Integer.parseInt(tpage);
////		}
////		if(null!=trows&&!"".equalsIgnoreCase(trows)){
////			rows=Integer.parseInt(trows);
////		}
////		rows=100;
//		Map<String,String> param=new HashMap<String,String>();
//		param.put("name", name);
//		
//		Map map=jlDepartmentInfoService.findList(user,page,rows,param);
//		List<Map> list=(List<Map>)map.get("list");
//		List<Map> temp=new ArrayList<Map>();
//		for(int i=0;i<list.size();i++){
//			if(list.get(i).get("parent_code")==null||list.get(i).get("parent_code").toString().equalsIgnoreCase("")){
//				continue;
//			}else{
////				if(list.get(i).get("name").equals("admin")){
////					continue;
////				}
//				temp.add(list.get(i));
//			}
//			
//		}
//		try {
//			this.jsonWrite(temp);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
