package com.microservice.main.service;

import com.microservice.main.model.Employee;

public interface HomeService {
	
	public Employee saveEmployee(Employee employee);
	
	public Iterable<Employee> getAllEmployee();
	
	public Employee updateEmployee(Employee employee,int id);
	
	public String deleteEmployeeById(int id);

	public Iterable<Employee> getEmployeebyAdd(String addr);

	public String deleteEmployee(Employee employee);
	

}


