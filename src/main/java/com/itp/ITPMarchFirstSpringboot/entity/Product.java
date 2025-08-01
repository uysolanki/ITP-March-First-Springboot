package com.itp.ITPMarchFirstSpringboot.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotNull(message = "Product Title cannot be null") 
	@Size(min = 3, message = "Product Title must contain at least 3 characters") 
	String title;
	
	@NotNull(message = "Price cannot be null") 
	@Min(value = 1, message = "Price must be at least 10,000") 
	@Max(value = 50000, message = "Price must be less than or equal to 50,000") 
	double price;
	
	@Size(min = 3, message = "Product Description name must contain at least 3 characters") 
	String description;
	
	@NotNull(message = "Product Category cannot be null") 
	@Size(min = 3, message = "Product Category must contain at least 3 characters") 
	String category;
	
	String image;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rating", referencedColumnName = "rid")
	
	
	Rating rating;

	private LocalDateTime createdAt;

	private LocalDateTime modifiedAt;

	@PrePersist
	protected void atCreation() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
		this.modifiedAt = now;
	}

	@PreUpdate
	protected void atUpdation() {
		this.modifiedAt = LocalDateTime.now();
	}

}
