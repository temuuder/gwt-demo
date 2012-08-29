package com.toto.test.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class Button1ClickEvent extends GwtEvent<Button1ClickEvent.Button1ClickEventHandler> {

	public static final Type<Button1ClickEventHandler> TYPE = new Type<Button1ClickEventHandler>();
	
	private String labelText;
	
	public interface Button1ClickEventHandler extends EventHandler {
		void onButton1Clicked(Button1ClickEvent event);
	}

	@Override
	public Type<Button1ClickEvent.Button1ClickEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Button1ClickEvent.Button1ClickEventHandler handler) {
		handler.onButton1Clicked(this);
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

}
