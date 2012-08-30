package com.toto.test.client.jsobjects;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Customer extends JavaScriptObject {

	protected Customer() {
		//nothing to do
	}
	
	public native final String getFirstName() /*-{ return this.FirstName; }-*/;
	public native final String getLastName()  /*-{ return this.LastName;  }-*/;

  // Note, though, that methods aren't required to be JSNI
  public final String getFullName() {
    return getFirstName() + " " + getLastName();
  }
  
  public static native JsArray<Customer> getCustomerArray() /*-{
  	return $wnd.jsonData;
  }-*/;
}
