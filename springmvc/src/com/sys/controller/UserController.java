package com.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.BaseController;
import com.zpj.entity.TestUser;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private Map<String,TestUser> users=new HashMap<String,TestUser>();
	
	public UserController(){
		users.put("", new TestUser());
		users.put("", new TestUser());
		users.put("", new TestUser());
		users.put("", new TestUser());
		users.put("", new TestUser());
		
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", users);
		return "user/list";
	}
	//get请求
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("user", new TestUser());
		return "user/add";
	}
	//具体添加用户post
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(TestUser user){
		return "redirect:/user/list";
	}
}
