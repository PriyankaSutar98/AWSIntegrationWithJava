package com.sample.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.pojo.Employee;

@Component
public interface EmployeeSerivce {

	public void setEmployeeDetails(Employee e);

	public Employee getEmployeeDetails(String Id);

	public List<Employee> getAllEmployeeDetails();

	public void deleteEmployee(String Id);

	public void updateEmployeeDetails(Employee emp);
}
