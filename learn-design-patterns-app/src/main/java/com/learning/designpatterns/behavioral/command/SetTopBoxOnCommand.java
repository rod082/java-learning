package com.learning.designpatterns.behavioral.command;

public class SetTopBoxOnCommand implements Command {

	private SetTopBox setTopBox;

	public SetTopBoxOnCommand(SetTopBox setTopBox) {
		this.setTopBox = setTopBox;
	}

	public void execute() {
		setTopBox.on();
		setTopBox.setChannel(10);
		setTopBox.setVolume(15);
	}
}
