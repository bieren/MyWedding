package com.sp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

public class StringUtil {

	public static List<String> addStringToList(List<String> resource,String addStr){
		Boolean isHave = false;
		for(String res:resource){
			if(res.equals(addStr)) 
				isHave=true;
		}
		if(!isHave) 
			resource.add(addStr);
		return resource;
	}
	
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	public static List<String> changeStringToList(String str)
	{
		String[] splitStrs = str.split(",");
		List<String> list = new ArrayList<String>();
		if(splitStrs.length == 0)
		{
			return null;
		}
		for(String splitStr:splitStrs)
		{
			list.add(splitStr);
		}
		return list;
	}
	
	public static String changeListToStr(List<String> resource)
	{
		StringBuilder builder = new StringBuilder();
		
		if(resource == null || resource.size() == 0)
			return null;
		
		for(String str:resource)
		{
			builder.append(str).append(",");
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}
	
	public static String changeString2Sql(String str)
	{
		StringBuilder builder = new StringBuilder();
		
		List<String> list = changeStringToList(str);
		for(int i=0;i<list.size();i++)
		{
			builder.append("'").append(list.get(i)).append("',");
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}
	
	public static String changeString2Sql(List<String> list)
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<list.size();i++)
		{
			builder.append("'").append(list.get(i)).append("',");
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}
	
	/**
	 * 判断集合是否为空
	 * @param list
	 * @return
	 */
	public static boolean isListEmpty(List<String> list)
	{
		if(list == null || list.size() == 0)
			return true;
		return false;
	}
	
	/**
	 * 将长整形数据转换�?{len}长度的字符串,不够前面�?
	 * @param value
	 * @param len
	 * @return
	 */
	public static String numberPadding0(long value,int len){
	    return String.format("%0"+len+"d", value); 
	}
	
	/** 
	    * 将json格式的字符串解析成Map对象 <li> 
	    * json格式：{"name":"admin","retries":"3fff","testname" 
	    * :"ddd","testretries":"fffffffff"} 
	    */  
	public static HashMap<String, Object> toHashMap(Object object)  
	{
		HashMap<String, Object> data = new HashMap<String, Object>();
	    // 将json字符串转换成jsonObject
	    JSONObject jsonObject = JSONObject.fromObject(object);
	    @SuppressWarnings("rawtypes")
		Iterator it = jsonObject.keys();
	    // 遍历jsonObject数据，添加到Map对象  
	    while (it.hasNext())  
	    {
	    	String key = String.valueOf(it.next());
	        Object value = jsonObject.get(key);
	        data.put(key, value);
	    }
	    return data;
	} 
	
	
	public static void main(String[] args) throws Exception {
	}
}
