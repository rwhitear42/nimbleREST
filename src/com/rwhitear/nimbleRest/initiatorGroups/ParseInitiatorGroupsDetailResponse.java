package com.rwhitear.nimbleRest.initiatorGroups;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailObject;


public class ParseInitiatorGroupsDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseInitiatorGroupsDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetInitiatorGroupsDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetInitiatorGroupsDetailObject da = gson.fromJson( this.jsonText, GetInitiatorGroupsDetailObject.class);
		
		return da;
	}
	
}
