package com.muchiri.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.muchiri.user.entity.User;
import com.muchiri.user.repository.UserRepository;
import com.muchiri.user.valueobject.Department;
import com.muchiri.user.valueobject.ResponseTemplateVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("saveUser method inside service class called");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("getUserWithDepartment method inside service class called");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findById(userId).get();

		// getting department from the department service
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + Long.valueOf(user.getDepartmentId()),
				Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}

}
