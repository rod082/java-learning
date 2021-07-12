package com.learning.designpatterns.behavioral.visitor;

public class VisitorRunner {
	
	public static void main(String[] args) {
		
		JsonExportVisitor jsonExportVisitor = new JsonExportVisitor();
		
		Circle c = new Circle(new Point(1, 3), 4);
		c.move(1, 2);
		c.draw();
		c.accept(jsonExportVisitor);
		
		System.out.println("----------------------------------------------");
		Rectangle r = new Rectangle(new Point(1, 3), 10, 5);
		r.move(1, 2);
		r.draw();
		r.accept(jsonExportVisitor);

	}

}
