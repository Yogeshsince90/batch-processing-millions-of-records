package com.yogesh.batchprocessing.sequentialprocessing.repository;

import org.springframework.stereotype.Repository;

import com.yogesh.batchprocessing.sequentialprocessing.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
