package com.itp.ITPMarchFirstSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/products/sort/{field}/{direction}")
	public List<Product> sortProducts(@PathVariable String field,@PathVariable String direction)
	{
		return productService.sortProducts(field,direction);
	}
	
	@GetMapping("/productsByPagination/{pageNumber}/{pageSize}")
	public Page<Product> productsByPagination(@PathVariable int pageNumber,@PathVariable int pageSize)
	{
		return productService.productsByPagination(pageNumber,pageSize);
	}

	@GetMapping("/productsBySortAndPagination/{pageNumber}/{pageSize}/{fieldName}")
	public Page<Product> productsBySortAndPagination(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String fieldName)
	{
		return productService.productsBySortAndPagination(pageNumber,pageSize,fieldName);
	}
}
