package com.drishti.vendingmachine.components.notification.carrier;

import com.drishti.vendingmachine.components.notification.INotification;

public interface INotificationCarrier {
	public void send(INotification notification);
}
