package com.itp.ITPMarchFirstSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.ITPMarchFirstSpringboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
		@Query(value="select * from product order by ?1 ?2",nativeQuery = true)
		public List<Product> sortProducts(String field, String direction);
}
