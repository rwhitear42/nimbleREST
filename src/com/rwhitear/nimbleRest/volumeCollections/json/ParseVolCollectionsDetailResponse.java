package com.rwhitear.nimbleRest.volumeCollections.json;

import com.google.gson.Gson;

public class ParseVolCollectionsDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseVolCollectionsDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	
	public VolCollectionsDetailJsonObject parse() {
			
		Gson gson = new Gson();
		
		VolCollectionsDetailJsonObject da = gson.fromJson( this.jsonText, VolCollectionsDetailJsonObject.class );
		
		return da;

	}
}
