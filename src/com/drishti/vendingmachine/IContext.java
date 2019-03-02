package com.drishti.vendingmachine;

public interface IContext {
	public <T> T getComponent(Class<T> t);
	public void terminateVM();
}
