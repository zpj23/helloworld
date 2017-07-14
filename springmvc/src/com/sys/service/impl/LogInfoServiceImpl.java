package com.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aop.AopMethod;
import com.sys.dao.LogInfoDao;
import com.sys.entity.LogInfo;
import com.sys.entity.UserInfo;
import com.sys.service.LogInfoService;

@Service
@Component("jlLogInfoService")
public class LogInfoServiceImpl implements LogInfoService {
	@Autowired
	private LogInfoDao logInfoDao;
	
	
	public LogInfoDao getLogInfoDao() {
		return logInfoDao;
	}
	public void setLogInfoDao(LogInfoDao logInfoDao) {
		this.logInfoDao = logInfoDao;
	}
	@Override
	public void logInfo(LogInfo log) {
		logInfoDao.saveLog(log);
	}
	@Override
	public Map findList(UserInfo user, int page, int rows,
			Map<String, String> param) {
		List list=logInfoDao.findList(user,page,rows,param);
		int count=logInfoDao.findCount(user,param); 
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	@AopMethod(remark="批量删除日志信息",type="删除")
	public void delLog(String id) {
		logInfoDao.delLog(id);
	}
	@Override
	public List findTopFive(UserInfo user, int page, int rows,
			Map<String, String> param) {
		List list=logInfoDao.findTopFive(user,page,rows,param);
		return list;
	}
	
}
