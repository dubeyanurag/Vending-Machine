package com.drishti.vendingmachine.display;
import java.io.IOException;

import com.drishti.vendingmachine.notification.INotification;
import com.drishti.vendingmachine.notification.INotificationCarrier;
public class Display implements INotificationCarrier{

	@Override
	public void send(INotification notification) {
		System.out.println(notification.getNotificationMessage());
	}
	
}
