package com.learning.hibernate.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	private String country;
	private String city;
	private String street;
	private String postOffice;
	
	public Address() {
	}
	
	public Address(String country, String city, String street, String postOffice) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.postOffice = postOffice;
	}
	
}
