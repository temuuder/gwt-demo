package com.toto.test.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.toto.test.client.clientfactory.ClientFactory;
import com.toto.test.client.jsobjects.Customer;
import com.toto.test.client.mvp.MyActivityMapper;
import com.toto.test.client.mvp.MyAppController;
import com.toto.test.client.mvp.MyPlaceHistoryMapper;
import com.toto.test.client.places.Tab1Place;

public class TestModule implements EntryPoint {
	private Place defaultPlace;
	ClientFactory clientFactory = GWT.create(ClientFactory.class);
	private SimplePanel appWidget = new SimplePanel();
	
	public void onModuleLoad() {
		defaultPlace = new Tab1Place(clientFactory.getConstants().getFirstTitle());
		EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

	    // Start ActivityManager for the main widget with our ActivityMapper
	    ActivityMapper activityMapper = new MyActivityMapper(clientFactory);
	    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
	    activityManager.setDisplay(appWidget);

	    // Start PlaceHistoryHandler with our PlaceHistoryMapper
	    MyPlaceHistoryMapper historyMapper = GWT.create(MyPlaceHistoryMapper.class);
	    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	    historyHandler.register(placeController, eventBus, defaultPlace);

	    new MyAppController(clientFactory);
	    
	    RootPanel.get().add(appWidget);
	   
	   	// Goes to the place represented on URL else default place
	    historyHandler.handleCurrentHistory();
	    
	    //display and log json content 
	    for (int i =0 ; i < Customer.getCustomerArray().length(); i++)
	    	GWT.log("Customer[" + i +"] : " + Customer.getCustomerArray().get(i).getFullName());
	}

}
