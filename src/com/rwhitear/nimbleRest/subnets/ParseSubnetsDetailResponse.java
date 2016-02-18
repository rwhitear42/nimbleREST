package com.rwhitear.nimbleRest.subnets;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.subnets.json.GetSubnetsDetailObject;

public class ParseSubnetsDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseSubnetsDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetSubnetsDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetSubnetsDetailObject da = gson.fromJson( this.jsonText, GetSubnetsDetailObject.class);
		
		return da;
	}
	

}
