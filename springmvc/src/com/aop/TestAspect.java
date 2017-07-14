package com.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.common.SpringContext;
import com.sys.dao.LogInfoDao;
import com.sys.entity.LogInfo;
import com.sys.entity.UserInfo;
import com.util.DateHelper;



@Aspect
public class TestAspect {
	private static final Logger log =Logger.getLogger(TestAspect.class);
	
	@Autowired
	private LogInfoDao logDao;
	
	/**
	 * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	 * （* com.evan.crm.service.*.*（..））中几个通配符的含义： 
		|第一个 * —— 通配 随便返回值类型| 
		|第二个 * —— 通配包com.evan.crm.service下的随便class| 
		|第三个 * —— 通配包com.evan.crm.service下的随便class的随便办法| 
		|第四个 .. —— 通配 办法可以有0个或多个参数| 
	 * @Title aspect
	 * @author zpj
	 * @time 2017-2-28 上午10:14:41
	 */
	@Pointcut("execution(* com.*.service.impl.*(..))")
	public void aspect(){
		
	}
	
	/**
	 * 配置前置通知，使用在方法aspect()上注册的切入点
	 * 同时接受JoinPoint切入点对象可以没有该参数
	 * @Title before
	 * @param jp
	 * @author zpj
	 * @time 2017-2-28 上午10:14:51
	 */
	@Before("aspect()")
	public void before(JoinPoint jp){
		log.info("before:"+jp);
	}
	/**
	 * 配置环绕通知，使用在方法aspect()上注册的切入点
	 * @Title around
	 * @param joinPoint
	 * @return
	 * @author zpj
	 * @time 2017-5-26 下午4:45:46
	 */
	@Around("aspect()")
	public Object around(JoinPoint joinPoint){
		Object result=null;
		long start = System.currentTimeMillis();
		ProceedingJoinPoint pjp=(ProceedingJoinPoint) joinPoint;
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	        UserInfo userinfo=null;
	        if(request!=null){
		         userinfo = (UserInfo) request.getSession().getAttribute("jluserinfo");
	        }
			Map tmap = getMthodRemark(pjp);
			if(userinfo!=null){
	        	LogInfo loginfo=new LogInfo();
	        	loginfo.setId(UUID.randomUUID().toString());
	        	loginfo.setCreatetime(new Date());
	        	loginfo.setType((String)tmap.get("type"));
	        	loginfo.setDescription(DateHelper.getToday("yyyy-MM-dd HH:mm:ss")+"   "+userinfo.getUsername()+"  在"+(String)tmap.get("remark"));
	        	loginfo.setUserid(userinfo.getId());
	        	loginfo.setUsername(userinfo.getUsername());
	        	logDao.saveLog(loginfo);
	        }
			result=pjp.proceed();
			long end = System.currentTimeMillis();
//			System.out.println("type="+type);
			log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
		}
		return result;
	}
	
	 /**
	 * 自定义方法回去备注、和类型
	 * @Title getMthodRemark
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 * @author zpj
	 * @time 2017-5-26 下午5:15:50
	 */
	public static Map getMthodRemark(ProceedingJoinPoint joinPoint)  
	            throws Exception {  
	        String targetName = joinPoint.getTarget().getClass().getName();  
	        String methodName = joinPoint.getSignature().getName();  
	        Object[] arguments = joinPoint.getArgs();  
	  
	        Class targetClass = Class.forName(targetName);  
	        Method[] method = targetClass.getMethods();  
	        Map<String,String> retMap = new HashMap<String,String>();
	        for (Method m : method) {  
	            if (m.getName().equals(methodName)) {  
	                Class[] tmpCs = m.getParameterTypes();  
	                if (tmpCs.length == arguments.length) {  
	                    AopMethod methodCache = m.getAnnotation(AopMethod.class); 
	                    if(methodCache!=null){
	                    	retMap.put("remark", methodCache.remark());  
	                    	retMap.put("type", methodCache.type());
	                    }
	                    break;
	                }  
	            }  
	        }  
	        return retMap;  
	    }  
	    
	  
	
}
