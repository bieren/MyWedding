package com.sp.handler;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.dao.DepartmentDao;
import com.sp.dao.EmployeeDao;
import com.sp.entity.Employee;
import com.sp.utils.HttpClientUtils;
import com.sp.utils.MD5Utils;
import com.sp.utils.URL;

import net.sf.json.JSONObject;

/**   
 * @ClassName:  EmployeeHandler   
 * @Description:订单获取
 * @author: panzhican
 * @date:   2017年4月23日 下午3:07:59   
 */
@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeedao;

	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public String save(@PathVariable("id") Integer id, Employee employee) {

		employeedao.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String save(Employee employee) {
		employeedao.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "/login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1() {
		
		return "/login";
	}

	@RequestMapping(value = "/now", method = RequestMethod.POST)
	public String all(Map<String, Object> map,String placeId) {
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		
		jsonMap.put("placeId", placeId);
		
		JSONObject orderResult = HttpClientUtils.getHttpResJson(URL.getCustOrderListForEnterPrise_Url, URL.POST, jsonMap);
		
		map.put("orderResult", orderResult);
		
		return "/WEB-INF/pages/crud/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Map<String, Object> map,HttpSession session,HttpServletRequest request,String userName, String password) {
		request.removeAttribute("orderResult");
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("loginNr", userName);
		jsonMap.put("pwd", password);
		JSONObject result = HttpClientUtils.getHttpResJson(URL.enterpriseLogin_Url, URL.POST, jsonMap);
//		System.out.println(result);
		jsonMap.clear();
		
		if (result.get("code")==null) {
			map.put("msg", "登录失败！请求失败！");
			return "/login";
		}else if(!result.get("code").toString().equals("200")){
			map.put("msg", result.get("msg"));
			return "/login";
		}else{


			session.setAttribute("username", result.get("corp"));
			session.setAttribute("placeId",  result.get("placeId").toString());
			session.setAttribute("result", result);
			session.setAttribute("token", result.get("token").toString());
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String format = sdf.format(timestamp);

			jsonMap.put("placeId", result.get("placeId").toString());
//			jsonMap.put("orderTime", format);
			
			JSONObject orderResult = HttpClientUtils.getHttpResJson(URL.getCustOrderListForEnterPrise_Url, URL.POST, jsonMap);

//			System.out.println(orderResult);
//			map.put("result", result);
			map.put("orderResult", orderResult);
//			map.put("result", result);
//			map.put("result", result);
//			map.put("result", result);
			return "/WEB-INF/pages/crud/temp";
		}
		
	}
	
	
	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public String getOrder(Map<String, Object> map,HttpSession session,String placeId) {
//		request.removeAttribute("orderResult");
		Map<String, String> jsonMap = new HashMap<String, String>();
		
			
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String format = sdf.format(timestamp);

		jsonMap.put("placeId", placeId);
//				jsonMap.put("orderTime", format);
		
		JSONObject orderResult = HttpClientUtils.getHttpResJson(URL.getCustOrderListForEnterPrise_Url, URL.POST, jsonMap);

		map.put("orderResult", orderResult);
		return "/WEB-INF/pages/crud/index";
			
	}

	@RequestMapping(value = "/input/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("employee", employeedao.get(id));
		map.put("departments", departmentDao.getALL());
		return "/WEB-INF/pages/crud/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("departments", departmentDao.getALL());
		return "/WEB-INF/pages/crud/input";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String list(@PathVariable("id") Integer id) {

		employeedao.delete(id);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		map.put("employees", employeedao.getAll());
		map.put("loginName", "11111111111111111");
		
		
		
		return "/WEB-INF/pages/crud/list";
	}
}
