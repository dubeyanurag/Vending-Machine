package com.drishti.vendingmachine;

public interface IVendingMachine {
	public <T> T getComponent(Class<T> t);
}
