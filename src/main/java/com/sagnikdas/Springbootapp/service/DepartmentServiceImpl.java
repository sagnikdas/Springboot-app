package com.sagnikdas.Springbootapp.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagnikdas.Springbootapp.entity.Department;
import com.sagnikdas.Springbootapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public Department saveDepartment(Department department) {
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - saveDepartment");
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - fetchDepartmentList");
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - fetchDepartmentById");
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - deleteDepartmentById");
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {

		// get the department in the db and then modify it.
		Department depDB = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}

		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - updateDepartment");
		
		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		
		LOGGER.info("DepartmentServiceImpl - Inside Service Impl - fetchDepartmentByName");
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
