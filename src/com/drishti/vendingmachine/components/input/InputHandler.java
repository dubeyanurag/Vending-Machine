package com.drishti.vendingmachine.components.input;

import com.drishti.vendingmachine.IContext;
import com.drishti.vendingmachine.components.BaseVendingMachineDaemonComponent;
import com.drishti.vendingmachine.components.InvalidComponentStateException;
import com.drishti.vendingmachine.components.drinksmanager.DispatchFailedException;
import com.drishti.vendingmachine.components.drinksmanager.DrinksNameEnum;
import com.drishti.vendingmachine.components.drinksmanager.IDrinksManager;
import com.drishti.vendingmachine.components.notification.INotificationManager;
import com.drishti.vendingmachine.components.notification.NotificationTypesEnum;

public class InputHandler extends BaseVendingMachineDaemonComponent implements IInputHandler {
	private String input;

	private InputHandler(IContext context) {
		super(context);
	}

	public static IInputHandler newInstance(IContext vendingMachine) {
		return new InputHandler(vendingMachine);
	}

	public void handle(String input) {
		this.input = input;
		try {
			this.startComponent();
		} catch (InvalidComponentStateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doWork() {
		char inputType = input.charAt(0);
		switch (inputType) {
		case '0':
			context.terminateVM();
			break;
		case '1':
			try {
				int drinkId = Character.getNumericValue(input.charAt(1));
				context.getComponent(IDrinksManager.class).dispatchDrink(DrinksNameEnum.get(drinkId));
			} catch (DispatchFailedException e ) {
				context.getComponent(INotificationManager.class).notify(NotificationTypesEnum.ERROR,
						e.getMessage());
			}
			break;
		}
	}
}
