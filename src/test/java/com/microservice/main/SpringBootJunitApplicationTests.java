package com.microservice.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.microservice.main.model.Employee;
import com.microservice.main.repository.HomerRepository;
import com.microservice.main.service.HomeService;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootJunitApplicationTests {
	

	@Autowired
	private HomeService service;

	@MockBean
	private HomerRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee(4, "Pranya", "Pune");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.saveEmployee(employee));
	}
	@Test
	public void getEmployeeTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(376, "Danile", "USA"), new Employee(958, "Huy", "UK")).collect(Collectors.toList()));
		assertEquals(2, ((List<Employee>) service.getAllEmployee()).size());
	}
	
	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee(9, "Pranya", "Pune");
		service.deleteEmployee(employee);
		verify(repository, times(1)).delete(employee);
	}
	@Test
	public void getEmployeebyAddrTest() {
		String addr = "pune";
		when(repository.findByAddr(addr))
				.thenReturn(( Stream.of(new Employee(4, "Danile", "pune")).collect(Collectors.toList())));
		
		assertEquals(1, ((List<Employee>) service.getEmployeebyAdd(addr)).size());
	}
	@Test
	public void updateEmployeebyTest() {
	
		Employee employee = new Employee(1, "Pranya", "Pune");
      when(repository.save(any(Employee.class))).thenReturn(employee);
        
      employee.setAddr("jalna");
        Employee storedDetails = service.updateEmployee(employee,1);

        assertNotNull(storedDetails);
//		 employee.setAddr("jalna");
//		Employee employeeUpdated =  repository.save(employee);
//
//	        Assertions.assertThat(employeeUpdated.getAddr()).isEqualTo("jalna");
		
	}
    @Test
   
    @Rollback(value = false)
    public void deleteEmployeeIdTest(){

        Employee employee = new Employee(1, "Pranya", "Pune");

        repository.deleteById(1);

        //employeeRepository.deleteById(1L);
        Employee emp = repository.findById(employee.getId()).get();

        Assertions.assertThat(emp).isNull();
    }
	
		

}

