package com.learning.designpatterns.structural.decorate;

public class Example {

	public static void main(String[] args) {
		
		
		Shape shape = ShapeFactory.createShape();
		shape.draw();

	}

}
