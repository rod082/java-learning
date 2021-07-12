package com.learning.designpatterns.structural.decorate;

public class ShapeFactory {

	public static Shape createShape() {
		return new ShapeProxy();
	}
}
