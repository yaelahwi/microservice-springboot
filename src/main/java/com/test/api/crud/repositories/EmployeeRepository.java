package com.test.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.crud.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
