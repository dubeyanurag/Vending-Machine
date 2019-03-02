package com.drishti.vendingmachine.components;

import java.lang.Thread.State;

import com.drishti.vendingmachine.IContext;

public abstract class BaseVendingMachineDaemonComponent extends BaseVendingMachineComponent {
	private Thread workerThread;

	protected BaseVendingMachineDaemonComponent(IContext context) {
		super(context);
		workerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				doWork();
			}
		});
	}

	public abstract void doWork();

	@Override
	public void startComponent() throws InvalidComponentStateException {
		checkComponentState(ComponentStateEnum.STARTED);
		if (workerThread.getState() != State.RUNNABLE) {
			workerThread.start();
		} else {
			throw new InvalidComponentStateException("Invalid daemon component state to start it.");
		}
		this.componentState = ComponentStateEnum.STARTED;
	}

	@Override
	public void stopComponent() throws InvalidComponentStateException {
		checkComponentState(ComponentStateEnum.STOPPED);
		if (workerThread.getState() == State.RUNNABLE) {
			workerThread.stop();
		} else {
			throw new InvalidComponentStateException("Invalid daemon component state to stop it.");
		}
		this.componentState = ComponentStateEnum.STOPPED;
	}
}
