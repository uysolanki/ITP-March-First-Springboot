package com.itp.ITPMarchFirstSpringboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
     String title;
     double price;
     String description;
     String category;
     String image;
     @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name = "rating", referencedColumnName = "rid")
     Rating rating;
}
