package com.toto.test.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.toto.test.client.events.Button1ClickEvent;
import com.toto.test.client.events.Button2ClickEvent;

public interface ViewInterface extends IsWidget {
	
	void setPresenter(ViewPresenter presenter);
	void setLabel1Text(String text);
	void setLabel2Text(String text);
	String getTextbox1Text();
	String getTextbox2Text();
	void setDisplayedTab(int tabNumber);

	public interface ViewPresenter {
		public void goTo(Place place);
		
		public void onButtonTab1Click();
		public void onButtonTab2Click();
		public void onTriggerSave();
		
		public void onButton1ClickEvent(Button1ClickEvent event);
		public void onButton2ClickEvent(Button2ClickEvent event);
	}
	
}
