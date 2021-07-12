package com.learning.designpatterns.behavioral.visitor;

public interface ExportVisitor {

	void visitRectangle(Rectangle rectangle);

	void visitCircle(Circle circle);
}
