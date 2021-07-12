package com.learning.designpatterns.behavioral.templateMethod;

public class SoccerGame extends AbstractGame {
	
	@Override
	void initialize() {
		System.out.println("Soccer Game Initialized! Start playing.");
	}

	@Override
	void start() {
		System.out.println("Game Started. Welcome to Soccer game!");
	}

	@Override
	void end() {
		System.out.println("Game Finished!");
	}
}
