package com.drishti.vendingmachine.components.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drishti.vendingmachine.IContext;
import com.drishti.vendingmachine.components.BaseVendingMachineComponent;
import com.drishti.vendingmachine.components.ComponentStateEnum;
import com.drishti.vendingmachine.components.IVendingMachineComponent;
import com.drishti.vendingmachine.components.InvalidComponentStateException;
import com.drishti.vendingmachine.components.notification.carrier.INotificationCarrier;
import com.drishti.vendingmachine.components.notification.carrier.display.Display;

public class NotificationManagerFactory {
	public static IVendingMachineComponent newInstance(IContext context) {
		return new NotificationManager(context);
	}
	static class NotificationManager extends BaseVendingMachineComponent implements INotificationManager {
		private Map<NotificationTypesEnum,List<INotificationCarrier>> typeVsCarriers;

		private NotificationManager(IContext context) {
			super(context);
			typeVsCarriers = new HashMap<NotificationTypesEnum,List<INotificationCarrier>>();
		}

		public void notify(NotificationTypesEnum notificationType,String message) {
			for (INotificationCarrier carrier : typeVsCarriers.get(notificationType)) {
				carrier.send(new INotification() {

					@Override
					public String getNotificationMessage() {
						return message;
					}
				});
			}
		}

		@Override
		public void startComponent() throws InvalidComponentStateException {
			super.startComponent();
			List<INotificationCarrier> carriers= new ArrayList<INotificationCarrier>();
			carriers.add(new Display());
			typeVsCarriers.put(NotificationTypesEnum.INFO,carriers);
			typeVsCarriers.put(NotificationTypesEnum.WARNING,carriers);
			typeVsCarriers.put(NotificationTypesEnum.ERROR,carriers);
			this.componentState = ComponentStateEnum.STARTED;
		}

		@Override
		public void stopComponent() throws InvalidComponentStateException {
			super.stopComponent();
			this.componentState = ComponentStateEnum.STOPPED;
		}

	}
}
