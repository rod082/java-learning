package com.learning.hibernate.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "store_branch")
public class StoreBranch {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private long branchId;
	
	@OneToOne
	@JoinColumn(name = "store_id", referencedColumnName = "id")
	private Store store;
	
	private String branchName;
	
	private String branchLocation;
}
