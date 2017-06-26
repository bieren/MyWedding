package com.sp.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.entity.Department;
import com.sp.entity.Employee;


@Repository
public class EmployeeDao {

	@Autowired
	private DepartmentDao departmentDao;

	private static int initId=6;
	
	private static Map<Integer, Employee> employees;
	
	static{
		
		employees=new HashMap<>();
		employees.put(1, new Employee(1, "lastName01", "email01", 1, new Department(1, "departmentName01")));
		employees.put(2, new Employee(2, "lastName02", "email02", 1, new Department(2, "departmentName02")));
		employees.put(3, new Employee(3, "lastName03", "email03", 0, new Department(3, "departmentName03")));
		employees.put(4, new Employee(4, "lastName04", "email04", 0, new Department(4, "departmentName04")));
		employees.put(5, new Employee(5, "lastName05", "email05", 1, new Department(5, "departmentName05")));
		
	}
	
	
	public Collection<Employee> getAll(){
		
		return employees.values();
	}
	
	
	public void save(Employee employee){
		if(employee.getId()==null){
			employee.setId(initId++);
		}else{
			//��ҳ���в���ȡlastNameʱ ���������һ�д���
			employee.setLastName(employees.get(employee.getId()).getLastName());
			
		}
		employee.setDepartment(departmentDao.get(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
}
