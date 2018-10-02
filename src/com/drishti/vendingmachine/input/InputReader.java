package com.drishti.vendingmachine.input;

import java.util.Scanner;

import com.drishti.vendingmachine.IVendingMachine;

public class InputReader {
	private IVendingMachine vendingMachine;
	private Scanner scanner;
	public InputReader(IVendingMachine vendingMachine){
		this.vendingMachine = vendingMachine;
		scanner = new Scanner(System.in);
	}
	public void getUserInput() {
		do {
			String input = scanner.nextLine();
			new InputHandler(vendingMachine).handle(input);
		}while(true);
	}
}
