package com.util;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import com.sys.controller.JlbAppAction;


public class RestApplication extends ResourceConfig{

	public RestApplication() {
    	register(RequestContextFilter.class);
    	//register(SkillAction.class);
    	register(JlbAppAction.class);
    }

}
