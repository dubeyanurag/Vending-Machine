package com.drishti.vendingmachine.components;

import com.drishti.vendingmachine.IContext;

public abstract class BaseVendingMachineComponent implements IVendingMachineComponent {
	protected ComponentStateEnum componentState;
	protected IContext context;

	protected BaseVendingMachineComponent(IContext context) {
		this.componentState = ComponentStateEnum.NEW;
		this.context = context;
	}
	public void startComponent() throws InvalidComponentStateException {
		checkComponentState(ComponentStateEnum.STARTED);
		this.componentState = ComponentStateEnum.STARTED;
	}

	public void stopComponent() throws InvalidComponentStateException {
		checkComponentState(ComponentStateEnum.STOPPED);
		this.componentState = ComponentStateEnum.STOPPED;
	}
	protected void checkComponentState(ComponentStateEnum newState) throws InvalidComponentStateException{
		switch(newState){
		case NEW:
			if(componentState!=null){
				throw new InvalidComponentStateException("Cannot initialize already initialized component");
			}
			break;
		case STARTED:
			if(componentState==null || componentState==ComponentStateEnum.STARTED){
				throw new InvalidComponentStateException("Cannot start uninitialized/already started component");
			}
			break;
		case STOPPED:
			if(componentState==null || componentState==ComponentStateEnum.NEW || componentState==ComponentStateEnum.STOPPED){
				throw new InvalidComponentStateException("Cannot stop non-started component");
			}
			break;
		}
	}
	public ComponentStateEnum getComponentState() {
		return this.componentState;
	}
}
