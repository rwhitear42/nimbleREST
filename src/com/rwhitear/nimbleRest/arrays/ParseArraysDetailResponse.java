package com.rwhitear.nimbleRest.arrays;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.arrays.json.GetArraysDetailObject;


public class ParseArraysDetailResponse {
	
	private String jsonText;
	
	
	// Constructors.
	public ParseArraysDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetArraysDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetArraysDetailObject da = gson.fromJson( this.jsonText, GetArraysDetailObject.class);
		
		return da;
	}
	
}
