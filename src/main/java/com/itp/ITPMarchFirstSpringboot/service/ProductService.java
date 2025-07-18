package com.itp.ITPMarchFirstSpringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itp.ITPMarchFirstSpringboot.entity.Product;
import com.itp.ITPMarchFirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> loadMultipleProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> sortProducts(String field, String direction) {
		//return productRepository.sortProducts(field,direction);
		return productRepository.findAll(Sort.by(Sort.Direction.fromString(direction), field));
	}

}
