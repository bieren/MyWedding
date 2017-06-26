package com.sp.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.utils.HttpClientUtils;
import com.sp.utils.MD5Utils;
import com.sp.utils.URL;

import net.sf.json.JSONObject;

/**
 * @ClassName: RechargeHandler
 * @Description:临时充值
 * @author: panzhican
 * @date: 2017年5月31日 下午2:43:52
 */
@Controller
public class RechargeHandler {

	@RequestMapping(value = "/rechargeLogin", method = RequestMethod.POST)
	public String rechargeLogin(Map<String, Object> map, HttpSession session, HttpServletRequest request,
			String userName, String password) {
		request.removeAttribute("rechargeResult");
		Map<String, String> jsonMap = new HashMap<String, String>();

		
		jsonMap.put("loginNr", userName);
		jsonMap.put("pwd", password);

		if (userName == null || "".equals(userName)) {
			userName = "tempwtf";
			jsonMap.put("loginNr", userName);

			 if (password.length() == 32) {
			
			 }
			 password = MD5Utils.String2MD5(userName + password);
			
			jsonMap.put("pwd", password);
		}

		JSONObject result = HttpClientUtils.getHttpResJson(URL.loginByPwd_Url, URL.POST, jsonMap);
		// System.out.println(result);
		jsonMap.clear();

		if (result.get("code") == null) {
			map.put("msg", "登录失败！请求失败！");
			return "/login1";
		} else if (!result.get("code").toString().equals("200")) {
			map.put("msg", result.get("msg"));
			return "/login1";
		} else {

			session.setAttribute("rechargeResult", result);
			
			map.put("rechargeResult", result);
			return "/WEB-INF/pages/crud/rechargeRequest";
		}

	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String login1() {

		return "/login1";
	}

//	@RequestMapping(value = "/rechargeRequest", method = RequestMethod.GET)
//	public String rechargeRequest() {
//
//		return "/WEB-INF/pages/crud/rechargeRequest";
//	}

	@RequestMapping(value = "/tempRegister", method = RequestMethod.GET)
	public String tempRegister(Map<String, Object> map, HttpSession session,HttpServletRequest request) {

		return "WEB-INF/pages/crud/tempRegister";
	}


	@RequestMapping(value = "/rechargeForword", method = RequestMethod.GET)
	public String rechargeForword(Map<String, Object> map, HttpSession session,HttpServletRequest request) {

		return "WEB-INF/pages/crud/rechargeRequest";
	}

	


	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public String recharge(Map<String, Object> map, HttpSession session,HttpServletRequest request, String cardNumb ,String rechargeType,String amount ,String comment , String paymentMethod ) {
		Map<String, String> jsonMap = new HashMap<String, String>();

		if ("".equals(cardNumb)||"".equals(rechargeType)||"".equals(amount)||"".equals(comment)||"".equals(paymentMethod)) {
			request.setAttribute("msg", "缺少参数，充值失败！");
			return "WEB-INF/pages/crud/rechargeRequest";
		}

		jsonMap.put("cardNumb", cardNumb);
		jsonMap.put("rechargeType", rechargeType);
		
		double parseDouble = Double.parseDouble(amount);
		
		jsonMap.put("amount", ""+(int) (parseDouble * 100));
		jsonMap.put("comment", comment);
		jsonMap.put("paymentMethod", paymentMethod);
		
		
		
		JSONObject rechargeResult = HttpClientUtils.getHttpResJson(URL.recharge_Url, URL.POST,jsonMap);
		map.put("rechargeResult", rechargeResult);
		request.setAttribute("msg", rechargeResult.get("msg"));
		request.setAttribute("balance", rechargeResult.get("balance"));
		
		String string2 = rechargeResult.get("code").toString();
		if ("200".equals(string2)) {
			Object object = rechargeResult.get("balance");
			Object object2 = JSONObject.fromObject(object).get("amount");
			String string = object2.toString();
			String substring1 = string.substring(0, string.length()-2);
			String substring2 = string.substring(string.length()-2, string.length());
			Object object3 = JSONObject.fromObject(rechargeResult).get("recharge");
			String string3 = object3.toString();
			double parseDouble2 = Double.parseDouble(string3);
			
			
			String str = "成功充值 : "+ parseDouble2/100 +" 元　　　　余额（元）："+substring1+"."+substring2;
			request.setAttribute("bal", str );
		}
		
		return "WEB-INF/pages/crud/rechargeRequest";

	}
	
}
