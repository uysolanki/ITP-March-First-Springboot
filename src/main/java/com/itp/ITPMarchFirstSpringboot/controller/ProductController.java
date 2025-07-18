package com.itp.ITPMarchFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPMarchFirstSpringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

}
