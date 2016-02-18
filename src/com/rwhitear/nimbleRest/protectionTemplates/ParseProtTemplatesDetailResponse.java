package com.rwhitear.nimbleRest.protectionTemplates;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.protectionTemplates.json.GetProtTemplatesDetailObject;


public class ParseProtTemplatesDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseProtTemplatesDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetProtTemplatesDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetProtTemplatesDetailObject da = gson.fromJson( this.jsonText, GetProtTemplatesDetailObject.class);
		
		return da;
	}

}
