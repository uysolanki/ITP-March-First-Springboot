package com.itp.ITPMarchFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.ITPMarchFirstSpringboot.entity.Actor;
import com.itp.ITPMarchFirstSpringboot.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	ActorRepository actorRepository;

	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

}
