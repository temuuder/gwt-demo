package com.toto.test.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.toto.test.client.places.Tab1Place;
import com.toto.test.client.places.Tab2Place;

@WithTokenizers({
	Tab1Place.Tokenizer.class, 
	Tab2Place.Tokenizer.class
})
public interface MyPlaceHistoryMapper extends PlaceHistoryMapper {
	//nothing to add
}
