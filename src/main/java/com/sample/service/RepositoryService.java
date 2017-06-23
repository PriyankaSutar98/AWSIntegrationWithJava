package com.sample.service;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.sample.pojo.Employee;

@Component
@EnableScan
public interface RepositoryService extends CrudRepository<Employee, String> {
}
