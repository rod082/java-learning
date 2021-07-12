package com.learning.designpatterns.structural.decorate;

public class ShapeProxy implements Shape {
	Shape oldShape;

	public ShapeProxy() {
		oldShape = new ShapeImpl();
	}

	public void draw() {
		System.out.println("doing something before..");

		oldShape.draw();

		System.out.println("doing something after..");

	}
}
