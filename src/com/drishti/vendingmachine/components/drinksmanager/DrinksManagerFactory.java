package com.drishti.vendingmachine.components.drinksmanager;

import com.drishti.vendingmachine.IContext;
import com.drishti.vendingmachine.components.BaseVendingMachineComponent;
import com.drishti.vendingmachine.components.IVendingMachineComponent;

public class DrinksManagerFactory {
	public static IVendingMachineComponent newInstance(IContext context) {
		return new DrinksManager(context);
	}
	static class DrinksManager extends BaseVendingMachineComponent implements IDrinksManager{

		public DrinksManager(IContext context) {
			super(context);
		}

		@Override
		public void dispatchDrink(DrinksNameEnum drink) throws DispatchFailedException {
			throw new DispatchFailedException("No Drinks to dispatch");
		}
		
	}
}
