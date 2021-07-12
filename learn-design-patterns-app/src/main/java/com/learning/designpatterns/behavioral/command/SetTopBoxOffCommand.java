package com.learning.designpatterns.behavioral.command;

public class SetTopBoxOffCommand implements Command {

	private SetTopBox setTopBox;

	public SetTopBoxOffCommand(SetTopBox setTopBox) {
		this.setTopBox = setTopBox;
	}

	public void execute() {
		setTopBox.off();
	}
}



