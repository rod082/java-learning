package com.learning.designpatterns.behavioral.templateMethod;

public class ChessGame extends AbstractGame {
	
	@Override
	void initialize() {
		System.out.println("Chess Game Initialized! Start playing.");
	}

	@Override
	void start() {
		System.out.println("Game Started. Welcome to chess game!");
	}

	@Override
	void end() {
		System.out.println("Game Finished!");
	}
	

}
