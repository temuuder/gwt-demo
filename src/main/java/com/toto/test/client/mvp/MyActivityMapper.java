package com.toto.test.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.toto.test.client.activities.TestActivity;
import com.toto.test.client.clientfactory.ClientFactory;
import com.toto.test.client.places.Tab1Place;
import com.toto.test.client.places.Tab2Place;

public class MyActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public MyActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public Activity getActivity(Place place) {
		if (place instanceof Tab1Place) 
			return new TestActivity(clientFactory, (Tab1Place) place);
		else if (place instanceof Tab2Place) 
			return new TestActivity(clientFactory, (Tab2Place) place);
		else
			return null;
	}

}
