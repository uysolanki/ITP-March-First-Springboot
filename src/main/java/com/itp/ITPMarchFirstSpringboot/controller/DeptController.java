package com.itp.ITPMarchFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPMarchFirstSpringboot.entity.Dept;
import com.itp.ITPMarchFirstSpringboot.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@PostMapping("/addDept")
	public Dept addDept(@RequestBody Dept dept)
	{
		return deptService.addDept(dept);
	}

}
