package com.test.api.crud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="employee", schema="public")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_employee_id_seq")
	@SequenceGenerator(name="generator_employee_id_seq", sequenceName = "employee_id_seq", schema = "public", allocationSize = 1)
	private long employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_address")
	private String employeeAddress;
}
