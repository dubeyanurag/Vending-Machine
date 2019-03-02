package com.drishti.vendingmachine;

public class Main {

	public static void main(String args[]) {
		IVendingMachine vendingMachine = VendingMachineFactory.newInstance();
		vendingMachine.powerOn();
//		vendingMachine.powerOff();
	}
}