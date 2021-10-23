package com.sagnikdas.Springbootapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagnikdas.Springbootapp.entity.Department;
import com.sagnikdas.Springbootapp.error.DepartmentNotFoundException;
import com.sagnikdas.Springbootapp.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	// look into the constructor based DI
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment method of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDeparmentList() {
		LOGGER.info("Inside fetchDeparmentList List method of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchDepartmentById method of DepartmentController");
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		LOGGER.info("Inside updateDepartment method of DepartmentController");
		return departmentService.updateDepartment(departmentId, department);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		
		LOGGER.info("Inside deleteDepartmentById method of DepartmentController");
		
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted successfully";
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchdepartmentByName(@PathVariable("name") String departmentName) {
	
		LOGGER.info("Inside fetchdepartmentByName method of DepartmentController");
		
		return departmentService.fetchDepartmentByName(departmentName);
	}

	
	
}
