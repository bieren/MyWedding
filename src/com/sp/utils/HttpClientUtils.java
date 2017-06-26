package com.sp.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient工具类
 * @author Mengfh
 *
 */
public abstract class HttpClientUtils {
	/**
	 * 获取HTTP响应的JSON结果
	 * @param url 请求地址
	 * @param type 请求类型
	 * @return
	 */
	public static JSONObject getHttpResJson(String url, String type) {
		return getHttpResJson(url, type, null, null, new String[]{}, new File[]{});
	}
	
	/**
	 * 获取HTTP响应的JSON结果
	 * @param url 请求地址
	 * @param type 请求类型
	 * @param paramMap POST请求参数
	 * @return
	 */
	public static JSONObject getHttpResJson(String url, String type, Map<String, String> paramMap) {
		return getHttpResJson(url, type, paramMap,null, new String[]{}, new File[]{});
	}
		
	/**
	 * 获取HTTP响应的JSON结果
	 * @param url 请求地址
	 * @param type 请求类型
	 * @param paramMap POST请求参数
	 * @param files 文件集合
	 * @return
	 */
	public static JSONObject getHttpResJson(String url, String type, Map<String, String> paramMap, String paramJson, String[] fileNames, File[] files) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject json = new JSONObject();
		try {
			HttpResponse res = null;
			if(StringUtils.isNotBlank(type) && "POST".equals(type.toUpperCase())) {
				HttpPost post = new HttpPost(url); //POST请求
				//设置POST请求参数
				if(paramMap != null && !paramMap.isEmpty()) {
					List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
					for(Entry<String, String> entry : paramMap.entrySet()) {
						nvpList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
					}
					post.setEntity(new UrlEncodedFormEntity(nvpList, "UTF-8"));
				}
				//参数以Json格式请求
				if(StringUtils.isNotBlank(paramJson)){
					StringEntity s = new StringEntity(paramJson, "UTF-8");   // 中文乱码在此解决
					s.setContentType("application/json");
					post.setEntity(s);
				}
				//需要文件上传的情况
				if(fileNames != null && fileNames.length > 0 && files != null && files.length > 0 && fileNames.length == files.length) {
					MultipartEntityBuilder meb = MultipartEntityBuilder.create();
					for(int i = 0; i < files.length; i++) {
						FileBody fileBody = new FileBody(files[i]);
						meb.addPart(fileNames[i], fileBody); //设置文件体
					}
					post.setEntity(meb.build());
				}
				res = httpClient.execute(post); //进行POST请求
			} else {
				HttpGet get = new HttpGet(url); //GET请求
				res = httpClient.execute(get); //进行GET请求
			}
			if(res != null) {
				HttpEntity httpEntity = res.getEntity();
				if(HttpStatus.SC_OK == res.getStatusLine().getStatusCode()) {
					if (httpEntity != null) {
				        String result = EntityUtils.toString(httpEntity, "UTF-8");
				        if(result.indexOf("{")!=0){				     
				        	 result=result.substring(result.indexOf("{"),result.lastIndexOf("}")+1);
				        }
				       
				        json = JSONObject.fromObject(result);
				    }
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
