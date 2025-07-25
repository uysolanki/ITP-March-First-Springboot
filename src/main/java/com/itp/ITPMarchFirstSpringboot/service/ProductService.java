package com.itp.ITPMarchFirstSpringboot.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<Product> productsByPagination(int pageNumber, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public Page<Product> productsBySortAndPagination(int pageNumber, int pageSize, String fieldName) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, fieldName)));
	}

	public void deleteProduct(int prodId) {
		productRepository.deleteById(prodId);
		
	}

	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product getSingleProduct(int prodId) {
		Product product=null;
		Optional<Product> optionalProductBox=productRepository.findById(prodId);
		if(optionalProductBox.isPresent())
			product=optionalProductBox.get();
		return product;
	}

	public Product updateProduct(int prodId, Product newValues) {
		Product prodFromDB=getSingleProduct(prodId);
		if(newValues.getCategory()!=null)
		prodFromDB.setCategory(newValues.getCategory());
		
		prodFromDB.setDescription(newValues.getDescription());
		prodFromDB.setImage(newValues.getImage());
		prodFromDB.setPrice(newValues.getPrice());
		prodFromDB.setRating(newValues.getRating());
		prodFromDB.setTitle(newValues.getTitle());
		return productRepository.save(prodFromDB);
	}

	public long calTimeFromLastModify(int prodId) {
		Product prodFromDB=getSingleProduct(prodId);
		LocalDateTime productModifiedDateFromDb=prodFromDB.getModifiedAt();
		LocalDateTime currentDataTime=LocalDateTime.now();
		Duration duration = Duration.between(productModifiedDateFromDb, currentDataTime);
		
		long days = duration.toDays();
		return days;
		
	}

	
	

}
