package com.drishti.vendingmachine.input;

import com.drishti.vendingmachine.IVendingMachine;
import com.drishti.vendingmachine.notification.NotificationManager;

public class InputHandler extends Thread{
	private IVendingMachine vendingMachine;
	private String input;
	public InputHandler(IVendingMachine vendingMachine){
		this.vendingMachine = vendingMachine;
	}
	public void run() {
		vendingMachine.getComponent(NotificationManager.class).notify(input);
	}
	public void handle(String input) {
		this.input = input;
		this.start();
	}
}
