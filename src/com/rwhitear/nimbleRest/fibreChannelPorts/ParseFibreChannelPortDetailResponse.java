package com.rwhitear.nimbleRest.fibreChannelPorts;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.fibreChannelPorts.json.GetFibreChannelPortsDetailObject;


public class ParseFibreChannelPortDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseFibreChannelPortDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public GetFibreChannelPortsDetailObject parse() {
		
		Gson gson = new Gson();
		
		GetFibreChannelPortsDetailObject da = gson.fromJson( this.jsonText, GetFibreChannelPortsDetailObject.class);
		
		return da;
	}
	

}
