package com.drishti.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.drishti.vendingmachine.components.IVendingMachineComponent;
import com.drishti.vendingmachine.components.InvalidComponentStateException;
import com.drishti.vendingmachine.components.drinksmanager.DrinksManagerFactory;
import com.drishti.vendingmachine.components.drinksmanager.IDrinksManager;
import com.drishti.vendingmachine.components.input.IInputReader;
import com.drishti.vendingmachine.components.input.InputReaderFactory;
import com.drishti.vendingmachine.components.notification.INotificationManager;
import com.drishti.vendingmachine.components.notification.NotificationManagerFactory;
import com.drishti.vendingmachine.components.notification.NotificationTypesEnum;
import com.drishti.vendingmachine.components.recipestore.IRecipeStore;
import com.drishti.vendingmachine.components.recipestore.RecipeStoreFactory;

public class VendingMachineFactory {
	public static IVendingMachine newInstance() {
		return new VendingMachine();
	}

	static class VendingMachine implements IVendingMachine, IContext {
		private Map<Class, IVendingMachineComponent> typeVsComponent;

		private VendingMachine() {
			typeVsComponent = new LinkedHashMap<>();
			typeVsComponent.put(INotificationManager.class, NotificationManagerFactory.newInstance(this));
			typeVsComponent.put(IRecipeStore.class,RecipeStoreFactory
					.newInstance(this));
			typeVsComponent.put(IDrinksManager.class,DrinksManagerFactory.newInstance(this));
			typeVsComponent.put(IInputReader.class, InputReaderFactory.newInstance(this, System.in));
		}

		@Override
		public <T> T getComponent(Class<T> typeOfComponent) {
			return (T) typeVsComponent.get(typeOfComponent);
		}

		@Override
		public void powerOn() {
			for (IVendingMachineComponent component : typeVsComponent.values()) {
				try {
					component.startComponent();
				} catch (InvalidComponentStateException e) {
					e.printStackTrace();
				}
			}
			getComponent(INotificationManager.class).notify(NotificationTypesEnum.INFO, "Initialized!!");
		}

		@Override
		public void terminateVM() {
			List<IVendingMachineComponent> components = new ArrayList<IVendingMachineComponent>(
					typeVsComponent.values());
			Collections.reverse(components);
			for (IVendingMachineComponent component : components) {
				if (!(component instanceof IInputReader)) {
					try {
						component.stopComponent();
					} catch (InvalidComponentStateException e) {
						e.printStackTrace();
					}
				}
			}
			// Exiting system as thread blocked on readLine() cannot be interrupted.
			System.exit(0);

		}

		@Override
		public void powerOff() {
			terminateVM();
		}
	}
}
