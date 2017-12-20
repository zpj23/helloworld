package com.sys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.BaseController;
import com.sys.service.MenuInfoService;


@Controller
@RequestMapping("/menu")
public class MenuInfoController extends BaseController{
	
	@Autowired
	public MenuInfoService jlMenuInfoService;
	
	/**
	 * 跳转列表页面
	 * @Title toList
	 * @return
	 * @author zpj
	 * @time 2017-11-18 下午2:04:10
	 */
	@RequestMapping(value="/toList",method=RequestMethod.GET)
	public String toList(){
		return "menu/list";
	}
	/**
	 * 跳转数的页面
	 * @Title toMain
	 * @return
	 * @author zpj
	 * @time 2017-11-18 下午3:00:51
	 */
	@RequestMapping(value="/toMain",method=RequestMethod.GET)
	public String toMain(){
		return "menu/list_iframe";
	}
	/**
	 * 这里用一句话描述这个方法的作用
	 * @Title showChildNode
	 * @return
	 * @author zpj
	 * @time 2017-11-18 下午3:30:07
	 */
	@RequestMapping(value="/showChildNode",method=RequestMethod.GET)
	@ResponseBody
	public String showChildNode(@RequestParam("id") String id){
		Map<String,String> param=new HashMap<String,String>();
//		param.put("name", name);
		param.put("id", id);
		if(id!=null&&!id.equalsIgnoreCase("")){
			this.jsonData = jlMenuInfoService.findJson(param);
		}else{
			this.jsonData=jlMenuInfoService.findTopJson();
		}
		return jsonData;
	}
	
	
	
	
}
