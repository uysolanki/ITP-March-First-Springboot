package com.itp.ITPMarchFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPMarchFirstSpringboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
