package com.toto.test.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Tab1Place extends Place {

	private String labelText; 
	
	public Tab1Place(String labelText) {
		this.labelText = labelText;
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Tab1Place> {
		public Tab1Place getPlace(String token) {
			return new Tab1Place(token);
		}
		
		public String getToken(Tab1Place place) {
			return place.getLabelText();
		}
	}
}
