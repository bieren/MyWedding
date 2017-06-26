package com.sp.utils;

public class URL {

	
	public static final String GET="GET";
	public static final String POST="POST";
	/**
	 * 测试用服务器地址
	 */
//	public static final String serverIp="127.0.0.1:8080";
//	public static final String serverIp="127.0.0.1:8081";
//	public static final String OpenAPI="OpenAPI";
	
	/**
	 * 正式运营服务器地址
	 */
	public static final String serverIp="120.77.101.181";
	public static final String OpenAPI="OpenAPItest";
	
	
//	public static final String serverIp="www.csbfxc.com";


	
	/*新闻部分*/
	public static String getNewsByType_Url				="http://" + serverIp + "/"+ OpenAPI +"/system/news/getNewsByType?newsType=%s&newsNextType=%s&pages=%s&dataSize=%s";
	public static String upvoteNews_Url					="http://" + serverIp + "/"+ OpenAPI +"/system/news/upvoteNews";
	public static String getNewsContent_Url				="http://" + serverIp + "/"+ OpenAPI +"/system/news/getNewsContent?newsId=%s";
	public static String getNewsByKeyword_Url			="http://" + serverIp + "/"+ OpenAPI +"/system/news/getNewsByKeyword";
	
	/*用户部分*/
	public static String createEnterpriseCustomer_Url	="http://" + serverIp + "/"+ OpenAPI +"/user/customer/createEnterpriseCustomer";
	public static String updateCustomer_Url				="http://" + serverIp + "/"+ OpenAPI +"/user/customer/updateCustomer";
	public static String customerLogin_Url				="http://" + serverIp + "/"+ OpenAPI +"/user/customer/customerLogin";
	public static String sendMobileCode_Url				="http://" + serverIp + "/"+ OpenAPI +"/user/customer/sendMobileCode";
	public static String getMobileCode_Url				="http://" + serverIp + "/"+ OpenAPI +"/user/customer/getMobileCode";
	public static String loginByPwd_Url					="http://" + serverIp + "/"+ OpenAPI +"/system/loginByPwd";
	public static String enterpriseLogin_Url			="http://" + serverIp + "/"+ OpenAPI +"/system/enterpriseLogin";
	public static String getCustOrderListForEnterPrise_Url="http://" + serverIp + "/"+ OpenAPI +"/device/getCustOrderListForEnterPrise";
	

	/*提交表单*/
	public static String submitCooperation_Url			="http://" + serverIp + "/"+ OpenAPI +"/system/news/addProspectCustomer";
	/*充值*/
	public static String recharge_Url					="http://" + serverIp + "/"+ OpenAPI +"/system/recharge";


}
