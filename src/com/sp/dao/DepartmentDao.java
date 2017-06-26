package com.sp.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sp.entity.Department;

@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments=null;
	
	static{
		
		departments=new HashMap<>();
		departments.put(1, new Department(1, "departmentName01"));
		departments.put(2, new Department(1, "departmentName02"));
		departments.put(3, new Department(1, "departmentName03"));
		departments.put(4, new Department(1, "departmentName04"));
		departments.put(5, new Department(1, "departmentName05"));
		
	}
	
	public Collection<Department> getALL(){
		return departments.values();
	}
	
	public Department get(Integer id){
		return departments.get(id);
	}
	
}
