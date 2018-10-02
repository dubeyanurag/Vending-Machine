package com.drishti.vendingmachine.display;
import com.drishti.vendingmachine.notification.INotification;
import com.drishti.vendingmachine.notification.INotificationCarrier;
public class Display implements INotificationCarrier{

	@Override
	public void send(INotification notification) {
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println(notification.getNotificationMessage());
	}
	
}
