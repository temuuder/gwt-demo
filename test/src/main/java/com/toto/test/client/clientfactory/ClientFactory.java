package com.toto.test.client.clientfactory;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.toto.test.client.resources.AppConstants;
import com.toto.test.client.view.ViewInterface;
import com.toto.test.shared.TestEntityRequestFactory;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	ViewInterface getView();
	AppConstants getConstants();
	TestEntityRequestFactory getRequestFactory();
}
