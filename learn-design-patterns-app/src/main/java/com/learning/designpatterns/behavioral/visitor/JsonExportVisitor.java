package com.learning.designpatterns.behavioral.visitor;

public class JsonExportVisitor implements ExportVisitor {

	public void visitRectangle(Rectangle rectangle) {
		StringBuilder jsonBuild = new StringBuilder();
		jsonBuild.append("{\"Rectangle\": {").append("\"corner\":").append("{\"x\":").append(rectangle.getCornerPoint().getX());
		jsonBuild.append(", \"y\":").append(rectangle.getCornerPoint().getY()).append("} , \"length\": ").append(rectangle.getLengh());
		jsonBuild.append(", \"height\": ").append(rectangle.getHeight()).append("}}");
		System.out.println(jsonBuild.toString());
	}

	public void visitCircle(Circle circle) {
		StringBuilder jsonBuild = new StringBuilder();
		jsonBuild.append("{\"Circle\": {").append("\"center\":").append("{\"x\":").append(circle.getCenter().getX());
		jsonBuild.append(", \"y\":").append(circle.getCenter().getY()).append("} , \"radius\": ").append(circle.getRadius()).append("}}");
		System.out.println(jsonBuild.toString());		
	}

}
