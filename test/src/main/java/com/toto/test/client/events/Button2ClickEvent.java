package com.toto.test.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class Button2ClickEvent extends GwtEvent<Button2ClickEvent.Button2ClickEventHandler> {

	public static final Type<Button2ClickEventHandler> TYPE = new Type<Button2ClickEvent.Button2ClickEventHandler>();
	
	private String labelText;
	
	public interface Button2ClickEventHandler extends EventHandler {
		void onButton2Clicked(Button2ClickEvent event);
	}

	@Override
	public Type<Button2ClickEvent.Button2ClickEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Button2ClickEvent.Button2ClickEventHandler handler) {
		handler.onButton2Clicked(this);
	}
	
	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

}
