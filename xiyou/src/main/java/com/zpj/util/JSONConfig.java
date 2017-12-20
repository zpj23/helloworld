/**   
 * @Title: JSONConfig.java 
 * @Package cn.com.frame.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author gaob
 * @date 2012-7-16 上午10:36:22 
 * @version V1.0   
 */

package com.zpj.util;

import java.util.Collection;

import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * 
 * @description (获得加过时间转换的JSONCOnfig)
 * @author yufadong
 * @update 2017年5月18日 上午9:28:46
 */
public class JSONConfig {

	private static JsonConfig config;

	public static JsonConfig getConfig() {
		config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		config.registerDefaultValueProcessor(Collection.class,
				new DefaultValueProcessor() {
					@SuppressWarnings("rawtypes")
					@Override
					public Object getDefaultValue(Class arg0) {
						return "";
					}
				});

		return config;
	}
}
