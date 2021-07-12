package com.learning.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IteratorDesignPatternRunner {

	public static void main(String[] args) {
		Collection<User> listColl = getListCollection();
		Collection<User> linkedListColl = getLinkedListCollection();
		Collection<User> setColl = getSetCollection();
//
//		printCollection(listColl);
//		printCollection(linkedListColl);
//		printCollection(setColl);
		
		printCollectionUsingLambdaExpressions(listColl);
		printCollectionUsingLambdaExpressions(linkedListColl);
		printCollectionUsingLambdaExpressions(setColl);

	}

	static void printCollection(Collection<User> coll) {
		System.out.println("*************** printing collection *******************");

		Iterator<User> iter = coll.iterator();
		while (iter.hasNext()) {
			User u = (User) iter.next();
			System.out.println(u);
			System.out.println("next one -------------");
		}
	}

	static void printCollectionUsingLambdaExpressions(Collection<User> coll) {
		System.out.println("*************** printing collection (Using Lambda Expressions) *******************");
		coll.forEach(u ->  System.out.println(u));
	}
	
	static Collection<User> getListCollection() {
		List<User> list = new ArrayList<>();
		list.add(buildUser1());
		list.add(buildUser2());
		list.add(buildUser3());
		return list;
	}

	static Collection<User> getLinkedListCollection() {
		List<User> list = new LinkedList<>();
		list.add(buildUser1());
		list.add(buildUser2());
		list.add(buildUser3());
		return list;
	}

	static Collection<User> getSetCollection() {
		Set<User> set = new HashSet<>();
		set.add(buildUser1());
		set.add(buildUser2());
		set.add(buildUser3());
		return set;
	}

	static User buildUser1() {
		return new User(100, "USER-100");
	}

	static User buildUser2() {
		return new User(101, "USER-101");
	}

	static User buildUser3() {
		return new User(102, "USER-102");
	}

}
