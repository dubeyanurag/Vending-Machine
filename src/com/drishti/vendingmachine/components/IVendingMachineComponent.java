package com.drishti.vendingmachine.components;

public interface IVendingMachineComponent {
	public void startComponent() throws InvalidComponentStateException;
	public void stopComponent() throws InvalidComponentStateException;
	public ComponentStateEnum getComponentState();
}
