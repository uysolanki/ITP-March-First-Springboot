package com.itp.ITPMarchFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPMarchFirstSpringboot.entity.Actor;
import com.itp.ITPMarchFirstSpringboot.entity.Dept;
import com.itp.ITPMarchFirstSpringboot.service.ActorService;

@RestController
public class ActorController {
	
	@Autowired
	ActorService actorService;
	
	@PostMapping("/addActor")
	public Actor addActor(@RequestBody Actor actor)
	{
		return actorService.addActor(actor);
	}
}
