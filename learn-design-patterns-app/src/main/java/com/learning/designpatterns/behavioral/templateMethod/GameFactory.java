package com.learning.designpatterns.behavioral.templateMethod;

public class GameFactory {

	public static Game createGame(String gameClassName) {
		try {
			Class c = Class.forName(gameClassName);
			Game game = (Game) c.newInstance();
			return game;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}
}
