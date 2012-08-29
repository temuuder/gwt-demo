package com.toto.test.client.mvp;

import com.google.web.bindery.event.shared.EventBus;
import com.toto.test.client.activities.TestActivity;
import com.toto.test.client.clientfactory.ClientFactory;
import com.toto.test.client.events.Button1ClickEvent;
import com.toto.test.client.events.Button1ClickEvent.Button1ClickEventHandler;
import com.toto.test.client.events.Button2ClickEvent;
import com.toto.test.client.events.Button2ClickEvent.Button2ClickEventHandler;
import com.toto.test.client.view.ViewInterface.ViewPresenter;

public class MyAppController implements Button1ClickEventHandler, Button2ClickEventHandler {
	
	private EventBus eventBus;
	private ViewPresenter presenter;
	
	public MyAppController(ClientFactory clientFactory) {
		eventBus = clientFactory.getEventBus();
		presenter = new TestActivity(clientFactory);
		
		//event bindings
		eventBus.addHandler(Button1ClickEvent.TYPE, this);
		eventBus.addHandler(Button2ClickEvent.TYPE, this);
	}

	public void onButton2Clicked(Button2ClickEvent event) {
		presenter.onButton2ClickEvent(event);
	}

	public void onButton1Clicked(Button1ClickEvent event) {
		presenter.onButton1ClickEvent(event);
	}

}
