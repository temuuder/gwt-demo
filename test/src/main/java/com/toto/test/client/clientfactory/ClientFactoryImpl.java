/**
 * 
 */
package com.toto.test.client.clientfactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.toto.test.client.resources.AppConstants;
import com.toto.test.client.view.ViewInterface;
import com.toto.test.client.view.impl.TestUI;
import com.toto.test.shared.TestEntityRequestFactory;

/**
 * @author r000507
 *
 */
public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus = new SimpleEventBus();
	private PlaceController placeController = new PlaceController(eventBus);
	private ViewInterface viewInterface = new TestUI();
	private AppConstants constants = GWT.create(AppConstants.class);
	private TestEntityRequestFactory requestFactory = GWT.create(TestEntityRequestFactory.class);
	
	public ClientFactoryImpl() {
		requestFactory.initialize(eventBus);
	}
	
	public EventBus getEventBus() {
		return eventBus;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}
	
	public ViewInterface getView() {
		return viewInterface;
	}
	
	public AppConstants getConstants() {
		return constants;
	}

	public TestEntityRequestFactory getRequestFactory() {
		return requestFactory;
	}
}
