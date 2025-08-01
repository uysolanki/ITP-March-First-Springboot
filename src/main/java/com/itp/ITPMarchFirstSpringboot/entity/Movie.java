package com.itp.ITPMarchFirstSpringboot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mno;
	String mname;
	int ryear;
	
	@ManyToMany(mappedBy = "portfolio")
	List<Actor> starCast;


}
