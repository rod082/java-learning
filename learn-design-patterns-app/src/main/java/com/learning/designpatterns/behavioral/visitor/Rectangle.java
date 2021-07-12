package com.learning.designpatterns.behavioral.visitor;

public class Rectangle implements Shape {

	private Point cornerPoint;
	private int lengh;
	private int height;

	public Rectangle(Point cornerPoint, int lengh, int height) {
		setCornerPoint(cornerPoint);
		setLengh(lengh);
		setHeight(height);
	}

	public Point getCornerPoint() {
		return cornerPoint;
	}

	public void setCornerPoint(Point cornerPoint) {
		this.cornerPoint = cornerPoint;
	}

	public int getLengh() {
		return lengh;
	}

	public void setLengh(int lengh) {
		this.lengh = lengh;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void move(int x, int y) {
		System.out.print("Moving rectangle from: " + cornerPoint);
		cornerPoint.setX(x);
		cornerPoint.setY(y);
		System.out.println(" to the new poisition: " + cornerPoint);
	}

	public void draw() {
		System.out.println("Drawing rectangle:: " + toString());
	}
	
	public void accept(ExportVisitor visitor) {
		visitor.visitRectangle(this);
	}

	@Override
	public String toString() {
		return "Rectangle[cornerPoint:" + cornerPoint + ", lengh:" + lengh + ", height:" + height + "]";
	}
}
