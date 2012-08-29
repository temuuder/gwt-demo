package com.toto.test.client.resources;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.LocalizableResource.Generate;
import com.google.gwt.i18n.client.LocalizableResource.GenerateKeys;

@GenerateKeys
@Generate(format = "com.google.gwt.i18n.rebind.format.PropertiesFormat")
public interface AppConstants extends Constants {

	@DefaultStringValue("Toto first title")
	String getFirstTitle(); 
}
