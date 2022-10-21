package com.muchiri.department.service;

import org.springframework.stereotype.Service;

import com.muchiri.department.entity.Department;
import com.muchiri.department.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("saveDepartment method inside the service class called");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long depatmentId) {
		log.info("findDepartmentById method inside the service class called");
		return departmentRepository.findById(depatmentId).get();
	}

}
