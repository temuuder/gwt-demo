package com.toto.test.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Tab2Place extends Place {

	private String labelText; 
	
	public Tab2Place(String labelText) {
		this.labelText = labelText;
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Tab2Place> {
		public Tab2Place getPlace(String token) {
			return new Tab2Place(token);
		}
		
		public String getToken(Tab2Place place) {
			return place.getLabelText();
		}
	}
}
