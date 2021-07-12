package com.learning.designpatterns.behavioral.command;

public class SetTopBox {

	public void on() {
		System.out.println("SetTopBox is on");
	}

	public void off() {
		System.out.println("SetTopBox is off");

	}

	public void setChannel(int num) {
		System.out.println("SetTopBox is set to channel: " + num);
	}

	public void setVolume(int vol) {
		System.out.println("SetTopBox volume is set to: " + vol);
	}
}
