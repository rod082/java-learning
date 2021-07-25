package com.learning.hibernate.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_card", uniqueConstraints = { @UniqueConstraint(columnNames = "cardNumber") })
public class CustomerCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	private String cardNumber;

	private String cardType;

	private String nameOnCard;

	private int expDay;

	private int expMonth;

	private int expYear;

	private int cvv;

	public CustomerCard() {

	}

	public CustomerCard(Customer customer, String cardNumber, String cardType, String nameOnCard, int expDay,
			int expMonth, int expYear, int cvv) {
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.nameOnCard = nameOnCard;
		this.expDay = expDay;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
	}

}
