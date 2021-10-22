package com.sagnikdas.Springbootapp.controller;

import java.util.List;

import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagnikdas.Springbootapp.entity.Department;
import com.sagnikdas.Springbootapp.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	// look into the constructor based DI

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {

		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDeparmentList() {

		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		
		return departmentService.updateDepartment(departmentId, department);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted successfully";
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchdepartmentByName(@PathVariable("name") String departmentName) {
		
		return departmentService.fetchDepartmentByName(departmentName);
	}

	
	
}
