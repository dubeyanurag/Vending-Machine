package com.drishti.vendingmachine.components.input;

import java.io.InputStream;
import java.util.Scanner;

import com.drishti.vendingmachine.IContext;
import com.drishti.vendingmachine.components.BaseVendingMachineDaemonComponent;
import com.drishti.vendingmachine.components.ComponentStateEnum;
import com.drishti.vendingmachine.components.IVendingMachineComponent;

public class InputReaderFactory {
	public static IVendingMachineComponent newInstance(IContext vendingMachine, InputStream source) {
		return new InputReader(vendingMachine, source);
	}

	static class InputReader extends BaseVendingMachineDaemonComponent implements IInputReader {
		private Scanner scanner;
		ComponentStateEnum componentState;

		private InputReader(IContext context, InputStream source) {
			super(context);
			scanner = new Scanner(source);
		}

		@Override
		public void doWork() {
			do {
				String input = scanner.nextLine();
				InputHandler.newInstance(context).handle(input);
			} while (true);
		}
	}
}