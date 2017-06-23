package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.pojo.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeSerivce {

	@Autowired
	RepositoryService repoService;

	@Override
	public void setEmployeeDetails(Employee e) {
		repoService.save(e);
	}

	@Override
	public Employee getEmployeeDetails(String Id) {
		Employee e = repoService.findOne(Id);
		return e;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> empList = (List<Employee>) repoService.findAll();
		return empList;
	}

	@Override
	public void deleteEmployee(String Id) {
		repoService.delete(Id);

	}

	@Override
	public void updateEmployeeDetails(Employee e) {
		repoService.save(e);

	}

}
