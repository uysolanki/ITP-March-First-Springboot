package com.itp.ITPMarchFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.ITPMarchFirstSpringboot.entity.Dept;
import com.itp.ITPMarchFirstSpringboot.repository.DeptRepository;

@Service
public class DeptService {
		
		@Autowired
		DeptRepository deptRepository;

	public Dept addDept(Dept dept) {
		return deptRepository.save(dept);
	}

}
