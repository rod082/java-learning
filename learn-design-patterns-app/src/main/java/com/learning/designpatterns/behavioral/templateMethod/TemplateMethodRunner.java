package com.learning.designpatterns.behavioral.templateMethod;

public class TemplateMethodRunner {

	public static void main(String[] args) {
		System.out.println("** playChessGame:");
		playChessGame();

		System.out.println("----------------------------------------------------");

		System.out.println("** playSoccerGame:");
		playSoccerGame();
	}

	static void playChessGame() {
		Game game = GameFactory.createGame("com.learning.designpatterns.behavioral.templateMethod.ChessGame");
		game.play();
	}

	static void playSoccerGame() {
		Game game = GameFactory.createGame("com.learning.designpatterns.behavioral.templateMethod.SoccerGame");
		game.play();
	}
}
