package com.itp.ITPMarchFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.ITPMarchFirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

}
