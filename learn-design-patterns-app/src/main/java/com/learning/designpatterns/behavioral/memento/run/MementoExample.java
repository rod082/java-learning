package com.learning.designpatterns.behavioral.memento.run;

import com.learning.designpatterns.behavioral.memento.impl.TransactionFactory;
import com.learning.designpatterns.behavioral.memento.intf.Transaction;

public class MementoExample {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	static void test1() {
		System.out.println("=================== running with commit transaction example ===================");
		OnlineOrder onlineOrder = OnlineOrderBuilder.build(100, "LAPTOP", "Order Confirmed", 1254);
		
		Transaction transaction = TransactionFactory.getTransaction(onlineOrder);
		
		transaction.beginTransaction(onlineOrder);
		
		System.out.println("Online order before change >> " + onlineOrder);
		
		onlineOrder.setStatus("Shipped");
		//transaction.addTransaction(onlineOrder);
		
		// ... DO OTHER WORK
		System.out.println("Online order before commit >> " + transaction.getEntity());
		transaction.commitTransaction(onlineOrder);
		
		System.out.println("Online order after commit >> " + onlineOrder);
	}

	
	static void test2() {
		System.out.println("=================== running with rollback transaction example ===================");

		OnlineOrder onlineOrder = OnlineOrderBuilder.build(100, "LAPTOP", "Order Confirmed", 1254);
		
		Transaction transaction = TransactionFactory.getTransaction(onlineOrder);
		
		transaction.beginTransaction(onlineOrder);
		
		System.out.println("Online order before change >> " + onlineOrder);
		
		onlineOrder.setStatus("Shipped");
		transaction.addTransaction(onlineOrder);
		
		// ... DO OTHER WORK
		System.out.println("Online order before rollback >> " + onlineOrder);
		transaction.rollback(onlineOrder);
		
		System.out.println("Online order after rollback >> " + transaction.getEntity());
	}

}
