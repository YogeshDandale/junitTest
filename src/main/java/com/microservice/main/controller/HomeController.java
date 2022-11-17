package com.microservice.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.main.model.Employee;
import com.microservice.main.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@PostMapping("/emp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
	
		return new ResponseEntity<Employee>(homeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	@GetMapping("/emp")
	public ResponseEntity<Iterable<Employee>> getAllEmp() {
		
	
		return new ResponseEntity<Iterable<Employee>>(homeService.getAllEmployee(),HttpStatus.OK);
		
	}
	@GetMapping("/emp/{addr}")
	public ResponseEntity<Iterable<Employee>> getAllEmp(@PathVariable("addr")String s) {
		
	
		return new ResponseEntity<Iterable<Employee>>(homeService.getEmployeebyAdd(s),HttpStatus.OK);
		
	}
	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee,@PathVariable("id")int id) {
		
	
		return new ResponseEntity<Employee>(homeService.updateEmployee(employee,id),HttpStatus.OK);
		
	}
	@DeleteMapping("/emp")
	public ResponseEntity<String>  deleteEmp(@RequestBody Employee employee) {
		
	
		return new ResponseEntity<String>(homeService.deleteEmployee(employee),HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String>  deleteEmp(@RequestBody Employee employee,@PathVariable("id")int id) {
		
	
		return new ResponseEntity<String>(homeService.deleteEmployeeById(id),HttpStatus.NO_CONTENT);
		
	}

}
