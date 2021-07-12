package com.learning.designpatterns.behavioral.command;

public class CommandPatternRunner {

	static CommandPatternRunner app = new CommandPatternRunner();;

	SetTopBox box;

	Command setTopBoxOnCommand;
	Command setTopBoxOffCommand;

	public static void main(String[] args) {
		app.init();
		app.run();
	}

	void run() {
		RemoteControl remote = new RemoteControl();

		remote.setCommand(setTopBoxOnCommand);
		remote.pressButton();

		System.out.println("------------ calling other command ------------- ");

		remote.setCommand(setTopBoxOffCommand);
		remote.pressButton();
	}

	void init() {
		box = new SetTopBox();
		setTopBoxOnCommand = new SetTopBoxOnCommand(box);
		setTopBoxOffCommand = new SetTopBoxOffCommand(box);
	}

}
