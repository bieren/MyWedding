package com.sp.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * SpringMvc HTTP处理�?
 */
public class SpringMvcUtils {
	
	public static HttpSession getSession(){
		if(RequestContextHolder.getRequestAttributes()==null)
			return null;
		return ((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest().getSession();
	}
	
	public static HttpSession getSession(boolean isNew){
		return ((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest().getSession(isNew);
	}
	
	public static Object getSessionAttribute(String name){
	    HttpSession session = getSession(false);
	    return session != null ? session.getAttribute(name) : null;
	}
	
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest();
	}
	
	public static String getParameter(String name){
		return getRequest().getParameter(name);
	}
	
}
