package com.itp.ITPMarchFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPMarchFirstSpringboot.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>
{

}
