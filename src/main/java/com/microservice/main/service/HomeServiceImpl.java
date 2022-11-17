package com.microservice.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.main.model.Employee;
import com.microservice.main.repository.HomerRepository;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomerRepository homerRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return homerRepository.save(employee);
	}

	@Override
	public Iterable<Employee> getAllEmployee() {
		
		return homerRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee,int id) {
		employee.setId(id);
		
		return homerRepository.save(employee);
	}

	@Override
	public String deleteEmployeeById(int id) {
		homerRepository.deleteById(id);
		return "Delete SuccesFully";
		
	}
	@Override
	public Iterable<Employee> getEmployeebyAdd(String  addr) {
		
		return homerRepository.findByAddr(addr);
		
	}

	@Override
	public String deleteEmployee(Employee employee) {
		homerRepository.delete(employee);
		return "delete successFully";
	}
	

}
