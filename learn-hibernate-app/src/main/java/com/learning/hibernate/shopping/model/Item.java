package com.learning.hibernate.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "barcode", unique = true, nullable = false)
	private String barcode;
	
	private String name;
	
	private String manufactur;
	
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "store_branch_id", nullable = true)
	private StoreBranch storeBranch;
}
