package com.toto.test.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.toto.test.client.clientfactory.ClientFactory;
import com.toto.test.client.events.Button1ClickEvent;
import com.toto.test.client.events.Button2ClickEvent;
import com.toto.test.client.places.Tab1Place;
import com.toto.test.client.places.Tab2Place;
import com.toto.test.client.view.ViewInterface;
import com.toto.test.client.view.ViewInterface.ViewPresenter;
import com.toto.test.client.view.impl.TestUI;
import com.toto.test.server.domain.TestEntity;
import com.toto.test.shared.TestEntityProxy;
import com.toto.test.shared.TestEntityRequest;

public class TestActivity extends AbstractActivity implements ViewPresenter {

	interface Driver extends RequestFactoryEditorDriver<TestEntityProxy, TestUI> {}
	
	private ClientFactory clientFactory;
	private Tab1Place tab1Place;
	private Tab2Place tab2Place;
	private Driver driver = GWT.create(Driver.class);
	
	public TestActivity(ClientFactory clientFactory, Tab1Place place) {
		this(clientFactory);
		this.tab1Place = place;
	}
	
	public TestActivity(ClientFactory clientFactory, Tab2Place place) {
		this(clientFactory);
		this.tab2Place = place;
	}
	
	public TestActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ViewInterface view = clientFactory.getView();
		driver.initialize(clientFactory.getRequestFactory(), (TestUI) view);
		TestEntityRequest request = clientFactory.getRequestFactory().getTestEntityRequest();
		TestEntityProxy entity = request.create(TestEntityProxy.class);
		
		view.setPresenter(this);
		if (tab1Place != null) {
			view.setDisplayedTab(0);
			view.setLabel1Text(tab1Place.getLabelText());
			entity.setName(tab1Place.getLabelText());
		} else if (tab2Place != null) {
			view.setDisplayedTab(1);
			view.setLabel2Text(tab2Place.getLabelText());
			entity.setName(tab2Place.getLabelText());
		} else {
			view.setDisplayedTab(0);
			view.setLabel1Text(clientFactory.getConstants().getFirstTitle());
			entity.setName(clientFactory.getConstants().getFirstTitle());
		}
				
		panel.setWidget(view);
		driver.edit(entity, request);		
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	public void onButtonTab1Click() {
		TestEntityRequest context = clientFactory.getRequestFactory().getTestEntityRequest();
		TestEntityProxy proxy = context.create(TestEntityProxy.class);
		proxy.setName(clientFactory.getView().getTextbox1Text());
		context.getFromTab1(proxy).fire(new Receiver<TestEntityProxy>() {

			@Override
			public void onSuccess(TestEntityProxy response) {
				Button1ClickEvent eventToFire = new Button1ClickEvent();
				eventToFire.setLabelText(response.getName());
				clientFactory.getEventBus().fireEvent(eventToFire);			
			}
			
		});
		
		
	}

	public void onButtonTab2Click() {
		TestEntityRequest context = clientFactory.getRequestFactory().getTestEntityRequest();
		TestEntityProxy proxy = context.create(TestEntityProxy.class);
		proxy.setName(clientFactory.getView().getTextbox2Text());
		context.getFromTab2(proxy).fire(new Receiver<TestEntityProxy>() {
 
			@Override
			public void onSuccess(TestEntityProxy response) {
				Button2ClickEvent eventToFire = new Button2ClickEvent();
				eventToFire.setLabelText(response.getName());
				clientFactory.getEventBus().fireEvent(eventToFire);			
			}
			
		});
		
	}

	public void onButton1ClickEvent(Button1ClickEvent event) {
		clientFactory.getView().setLabel2Text(event.getLabelText());
		clientFactory.getView().setDisplayedTab(1);
	}

	public void onButton2ClickEvent(Button2ClickEvent event) {
		clientFactory.getView().setLabel1Text(event.getLabelText());
		clientFactory.getView().setDisplayedTab(0);
	}
	
	@Override
	public void onTriggerSave() {
		RequestContext returnObject = driver.flush();
		Window.alert(String.valueOf(returnObject.isChanged()));
	}

}
