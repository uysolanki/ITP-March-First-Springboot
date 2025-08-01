package com.itp.ITPMarchFirstSpringboot.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
public class Rating {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	int rid;
	 	
	 	@Min(value = 1, message = "Minimum Rating be at least 1") 
	 	@Max(value = 5, message = "Maximum Rating can be 5") 
	 	double rate;
	    int count;

}
