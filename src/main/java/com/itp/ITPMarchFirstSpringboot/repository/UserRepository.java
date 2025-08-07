package com.itp.ITPMarchFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPMarchFirstSpringboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
        public User findByUserName(String user);
}
