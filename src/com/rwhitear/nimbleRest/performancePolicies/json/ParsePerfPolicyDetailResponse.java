package com.rwhitear.nimbleRest.performancePolicies.json;

import com.google.gson.Gson;


public class ParsePerfPolicyDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParsePerfPolicyDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	
	public PerfPoliciesDetailJsonObject parse() {
		
		Gson gson = new Gson();
		
		PerfPoliciesDetailJsonObject da = gson.fromJson( this.jsonText, PerfPoliciesDetailJsonObject.class );
		
		return da;

	}


}
