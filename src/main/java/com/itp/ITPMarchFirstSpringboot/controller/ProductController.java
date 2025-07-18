package com.itp.ITPMarchFirstSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPMarchFirstSpringboot.entity.Product;
import com.itp.ITPMarchFirstSpringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/loadMultipleProducts")
	public List<Product> loadMultipleProducts(@RequestBody List<Product> products)
	{
		return productService.loadMultipleProducts(products);
	}

}
