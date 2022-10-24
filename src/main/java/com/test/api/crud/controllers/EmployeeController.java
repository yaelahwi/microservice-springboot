package com.test.api.crud.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.crud.dtos.EmployeeDTO;
import com.test.api.crud.models.Employee;
import com.test.api.crud.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	

	private Employee convertEmployeeToEntity (EmployeeDTO employeeDto) {
		return modelMapper.map(employeeDto, Employee.class);
	}
	
	private EmployeeDTO convertEmployeeToDTO (Employee employee) {
		return modelMapper.map(employee, EmployeeDTO.class);
	}
	
	
//	API CREATE Employee
	@PostMapping("/employee/create")
	public Map<String, Object> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Map<String, Object> mapResult = new HashMap<>();
		
		Employee employee = convertEmployeeToEntity(employeeDTO);
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
		
		mapResult.put("message", "Create Success");
		mapResult.put("data", employeeRepository.save(employee));
		
		return mapResult;
		
	}
	
//	API READ EMployee
	@GetMapping("/employee/get/all")
	public Map<String, Object> getAllEmployee () {
		Map<String, Object> mapResult = new HashMap<>();
		List<EmployeeDTO> listEmployeeDto = new ArrayList<>();
		
		for (Employee employee : employeeRepository.findAll()) {
			EmployeeDTO employeeDto = convertEmployeeToDTO(employee);
			listEmployeeDto.add(employeeDto);
		}
		
		String message;
		if (listEmployeeDto.isEmpty()) {
			message = "Data is empty";
		}
		else {
			message = "Show all data";
		}
		
		mapResult.put("message" , message);
		mapResult.put("data", listEmployeeDto);
		mapResult.put("total", listEmployeeDto.size());
		
		return mapResult;
		
	}
	
//	API UPDATE Employee
	@PutMapping("/employee/update")
	public Map<String, Object> updateEmployee (@RequestParam(value="employeeId") long employeeId, @RequestBody EmployeeDTO employeeDto) {
		Map<String, Object> mapResult = new HashMap<>();
		
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
		
		mapResult.put("message", "Update success");
		mapResult.put("data", employeeRepository.save(employee));
		
		return mapResult;
		
	}
	
//	API Delete Employee
	@DeleteMapping("/employee/delete/{employeeId}")
	public Map<String, Object> deleteEmployee (@PathVariable(value="employeeId") long employeeId) {
		Map<String, Object> mapResult = new HashMap<>();
		
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		employeeRepository.delete(employee);
		
		mapResult.put("message", "Delete Success");
		
	return mapResult;
	}
}
