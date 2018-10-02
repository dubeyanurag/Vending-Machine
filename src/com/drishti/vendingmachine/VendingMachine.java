package com.drishti.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import com.drishti.vendingmachine.display.Display;
import com.drishti.vendingmachine.input.InputReader;
import com.drishti.vendingmachine.notification.NotificationManager;

public class VendingMachine implements IVendingMachine{
	private Map<Class,Object> typeVsComponent;
	public VendingMachine() {
		typeVsComponent = new HashMap<>();
		typeVsComponent.put(Display.class, new Display());
		typeVsComponent.put(NotificationManager.class, new NotificationManager(this));
		getComponent(NotificationManager.class).notify("Initializing !!");
	}
	public <T> T getComponent(Class<T> typeOfComponent) {
		return (T) typeVsComponent.get(typeOfComponent);
	}
	public void start() {
		new InputReader(this).getUserInput();
	}
}
