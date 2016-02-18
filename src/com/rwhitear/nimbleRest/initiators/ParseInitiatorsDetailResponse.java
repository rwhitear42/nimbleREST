package com.rwhitear.nimbleRest.initiators;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.initiators.json.GetInitiatorsDetailObject;


public class ParseInitiatorsDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseInitiatorsDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetInitiatorsDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetInitiatorsDetailObject da = gson.fromJson( this.jsonText, GetInitiatorsDetailObject.class);
		
		return da;

	}
}
