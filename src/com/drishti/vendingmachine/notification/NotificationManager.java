package com.drishti.vendingmachine.notification;

import java.util.ArrayList;
import java.util.List;

import com.drishti.vendingmachine.IVendingMachine;
import com.drishti.vendingmachine.display.Display;

public class NotificationManager {
	private List<INotificationCarrier> carriers;
	public NotificationManager(IVendingMachine vendingMachine){
		carriers = new ArrayList<>();
		carriers.add(vendingMachine.getComponent(Display.class));
	}
	public void notify(String message){
		for(INotificationCarrier carrier: carriers) {
			carrier.send(new INotification() {
				
				@Override
				public String getNotificationMessage() {
					return message;
				}
			});
		}
	}
}
