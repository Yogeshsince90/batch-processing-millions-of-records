package com.yogesh.batchprocessing.sequentialprocessing.config;

import org.springframework.batch.item.ItemProcessor;

import com.yogesh.batchprocessing.sequentialprocessing.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee item) throws Exception {
		
		// Any filtration/ transformation logic can be added here
		// I am not doing anything here. just a pass through
		
		return item;
	}
	
	

}
