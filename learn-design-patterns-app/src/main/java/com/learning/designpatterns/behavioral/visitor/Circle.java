package com.learning.designpatterns.behavioral.visitor;

public class Circle implements Shape {

	private Point center;
	private int radius;

	public Circle(Point center, int radius) {
		setCenter(center);
		setRadius(radius);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void move(int x, int y) {
		System.out.print("Moving circle from: " + center);
		center.setX(x);
		center.setY(y);
		System.out.println(" to the new poisition: " + center);
	}

	public void draw() {
		System.out.println("Drawing circle:: " + toString());
	}

	public void accept(ExportVisitor visitor) {
		visitor.visitCircle(this);
	}

	@Override
	public String toString() {
		return "Circle[center:" + center + ", lengh:" + radius + "]";
	}

}
