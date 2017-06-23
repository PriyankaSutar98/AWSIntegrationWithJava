package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.pojo.Employee;
import com.sample.service.EmployeeSerivce;

/*	@Autowired
private AmazonDynamoDB amazonDynamoDB;

private DynamoDBMapper dynamoDBMapper;

 
	 * Table creation 
	 * 
	 * dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
	 CreateTableRequest tableRequest =
	 dynamoDBMapper.generateCreateTableRequest(Employee.class);

	 tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,
	 1L));
	 CreateTableResult res= amazonDynamoDB.createTable(tableRequest);
	 TableDescription des=res.getTableDescription();
	 System.out.println(des.getTableName());*/

@RestController
public class EmployeeController {

	@Autowired
	EmployeeSerivce employeeService;

	@RequestMapping(value = "/EnterEmployeeDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> setEmployeeDetails(@RequestBody Employee emp) {
		try {
			employeeService.setEmployeeDetails(emp);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@RequestMapping(value = "/GetEmployeeDetails/{Id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeDetail(@PathVariable String Id) {
		Employee e = employeeService.getEmployeeDetails(Id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@RequestMapping(value = "/UpdateEmployeeDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployeeDetail(@RequestBody Employee emp) {
		employeeService.updateEmployeeDetails(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(value = "/DeleteEmployeeDetails/{Id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> deleteEmployeeDetail(@PathVariable String Id) {
		employeeService.deleteEmployee(Id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@RequestMapping(value = "/GetAllEmployeeDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployeeDetail() {
		List<Employee> empList = employeeService.getAllEmployeeDetails();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

}
