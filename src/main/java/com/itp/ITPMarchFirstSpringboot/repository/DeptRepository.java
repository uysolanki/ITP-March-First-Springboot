package com.itp.ITPMarchFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPMarchFirstSpringboot.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer>
{

}
