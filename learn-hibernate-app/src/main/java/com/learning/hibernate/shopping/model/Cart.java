package com.learning.hibernate.shopping.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinTable(name = "cart_item", 
		joinColumns = {	@JoinColumn(name = "cart_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "item_id") }
		)
	private List<Item> items;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "store_branch_id", nullable = false)
	private StoreBranch storeBranch;
	
	public void addItem(Item item) {
		if (items == null) {
			items = new LinkedList<>();
		}
		items.add(item);
	}

}
