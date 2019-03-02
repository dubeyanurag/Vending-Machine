package com.drishti.vendingmachine.components.notification.carrier.display;
import com.drishti.vendingmachine.components.notification.INotification;
import com.drishti.vendingmachine.components.notification.carrier.INotificationCarrier;
public class Display implements INotificationCarrier{

	@Override
	public void send(INotification notification) {
		System.out.println(notification.getNotificationMessage());
	}
	
}
