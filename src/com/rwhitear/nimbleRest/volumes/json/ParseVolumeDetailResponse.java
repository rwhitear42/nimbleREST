package com.rwhitear.nimbleRest.volumes.json;

import com.google.gson.Gson;

public class ParseVolumeDetailResponse {

	private String jsonText;
	
	
	// Constructors.
	public ParseVolumeDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public VolumesDetailJsonObject parse() {
		Gson gson = new Gson();
		
		VolumesDetailJsonObject da = gson.fromJson( this.jsonText, VolumesDetailJsonObject.class);
		
		return da;
	}
	

}
