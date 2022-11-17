package com.microservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.main.model.Employee;

@Repository
public interface HomerRepository extends JpaRepository<Employee, Integer> {

	public Iterable<Employee> findByAddr(String addr);

}
