package com.zpj.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zpj.entity.TestUser;
import com.zpj.service.TestService;
import com.zpj.util.JSONConfig;

@Controller
@RequestMapping("/wel")
public class TestController {
	
	@Autowired 
	private TestService testService;  
	//表示用指定的一个url来找
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	//把值传给controller  username不传会报错
	public String hello(@RequestParam("username") String username){
		return "";
	}
	@RequestMapping(value="/hello1", method = RequestMethod.GET ,params="json")  
	public String hello1(@RequestParam("username") String username){
		return "";
	}
	@RequestMapping(value="/hello1", method = RequestMethod.GET)  
	public String hello1(String username,Map<String,Object> context){
		context.put("he","111");
		return "";
	}
	
	public String hello1(String username,Model m){
		m.addAttribute("username","111");
		//默认使用对象的类型作为key。。m.addAttribute("string",username);
		m.addAttribute(username);
		return "";
	}
	
	
	@RequestMapping(value="/{day}", method = RequestMethod.GET)  
    public void getForDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model) {  
         
    }  
	@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)  
	public String findOwner(@PathVariable String ownerId) {  
	  return "displayOwner";   
	}  
	/**
	 * 方法仅处理request Content-Type为“application/json”类型的请求。
	 * @Title addPet
	 * @param pet
	 * @param model
	 * @author zpj
	 * @time 2017-6-1 下午5:31:17
	 */
	@RequestMapping(value = "/pets", method = RequestMethod.POST, consumes="application/json")  
	
	public void addPet(@RequestBody TestUser pet, Model model) {      
	    // implementation omitted  
	}  
	
	/**
	 * 方法仅处理request请求中Accept头中包含了"application/json"的请求，同时暗示了返回的内容类型为application/json;
	 * @Title getPet
	 * @param petId
	 * @param model
	 * @author zpj
	 * @time 2017-6-1 下午5:31:59
	 */
	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, produces="application/json")  
	@ResponseBody  
	public void getPet(@PathVariable String petId, Model model) {      
	    // implementation omitted  
	}  
	
	/**
	 *  仅处理请求中包含了名为“myParam”，值为“myValue”的请求；
	 * @Title findPet
	 * @param ownerId
	 * @param petId
	 * @param model
	 * @author zpj
	 * @time 2017-6-1 下午5:33:29
	 */
	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, params="myParam=myValue")  
	  public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {      
	    // implementation omitted  
	  }  
	/**
	 * 仅处理request的header中包含了指定“Refer”请求头和对应值为“http://www.ifeng.com/”的请求；
	 * @Title findPet1
	 * @param ownerId
	 * @param petId
	 * @param model
	 * @author zpj
	 * @time 2017-6-1 下午5:33:43
	 */
	@RequestMapping(value = "/pets", method = RequestMethod.GET, headers="Referer=http://www.ifeng.com/")  
	  public void findPet1(@PathVariable String ownerId, @PathVariable String petId, Model model) {      
	    // implementation omitted  
	  }  
	
	/**
	 * 接口
	 * @Title getUserInfo
	 * @param req
	 * @param res
	 * @author zpj
	 * @time 2017-6-1 下午3:43:50
	 */
	@RequestMapping(value = "/getUserInfo"
			,method = RequestMethod.POST   
//			,consumes = {MediaType.TEXT_PLAIN,MediaType.TEXT_HTML} 
			,produces = {MediaType.APPLICATION_JSON,"application/json;charset=UTF-8"}
	)  
	@ResponseBody
	public JSONObject getUserInfo(@RequestParam("id") String id){
		JSONObject json = null;
		JsonConfig jsonConfig = JSONConfig.getConfig();
		
		TestUser u=testService.findUserInfoById(id);
		jsonConfig.setExcludes(new String[]{""});
		json = JSONObject.fromObject(u,jsonConfig);
		return json;
	}
	public void jsonWrite(HttpServletResponse response,Object str) throws IOException{		
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd HH:mm:ss")
		.create();
		String json_ = gson.toJson(str);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json_);
	}
	@RequestMapping("/doAdd")
	public void doAddUser(){
		TestUser u=new TestUser();
		u.setNick_name("呵呵");
		u.setPassword("111111");
		u.setBalance(10);
		u.setBirth("198911");
		u.setClient_type("0");
		u.setLast_login_time(new Date());
		u.setPhone("1246789123");
		u.setRegister_time(new Date());
		u.setRemain_time(1000);
		u.setSex("1");
		u.setTotal_charge_time(100);
		u.setType("1");
		u.setUpdate_time(new Date());
		u.setWxunionid(UUID.randomUUID().toString());
		testService.addUser(u);
	}
	
	@RequestMapping("test/login.do")  
    public String testLogin(@RequestParam(value="username")String username, String password, HttpServletRequest request) {  
  
        if (!"admin".equals(username) || !"admin".equals(password)) {  
            return "loginError"; 
        }  
        return "loginSuccess";  
    }  
  
    @RequestMapping("/test/login2.do")  
    public ModelAndView testLogin2(String username, String password, int age){  
          
        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {  
            return new ModelAndView("loginError"); 
        }  
        return new ModelAndView(new RedirectView("../index.jsp"));  
    }  
  
   
  
//    @RequestMapping("/test/login4.do")  
//    public String testLogin4(User user) {  
//        if (loginService.login(user) == false) {  
//            return "loginError";  
//        }  
//        return "loginSuccess";  
//    }  
}
