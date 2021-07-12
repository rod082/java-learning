package com.learning.designpatterns.behavioral.templateMethod;

public abstract class AbstractGame implements Game {

	abstract void initialize();

	abstract void start();

	abstract void end();

	public final void play() {
		// initialize the game
		initialize();
		// start game
		start();
		// end game
		end();
	}
}
