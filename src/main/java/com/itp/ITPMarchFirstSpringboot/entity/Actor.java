package com.itp.ITPMarchFirstSpringboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ano;
	String aname;
	int age;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(		
			name = "Hotstar",		
			joinColumns = @JoinColumn(name="fAno"),
			inverseJoinColumns = @JoinColumn(name="fMno")
			)
	List<Movie> portfolio;

}
