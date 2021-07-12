package com.learning.designpatterns.structural.decorate;

public class ShapeWrapper implements Shape {

	Shape oldShape;

	public ShapeWrapper() {
		oldShape = new ShapeImpl();
	}

	public void draw() {
		oldShape.draw();

		System.out.println("after calling old shape .. dowing another new drawing..");

	}

}
