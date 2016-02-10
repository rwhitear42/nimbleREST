package com.rwhitear.nimbleRest.accessControlRecords.json;

import com.google.gson.Gson;

public class GetACRdetailResponse {
	
	private String jsonText;
	
	//Constructor.
	public GetACRdetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}

	public void outputJSON() {
		
		Gson gson = new Gson();
		
		ACRobject da = gson.fromJson(jsonText, ACRobject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			System.out.println("Data["+i+"] Volume Name: " +da.getData().get(i).getVol_name());
			System.out.println("Data["+i+"] ACR ID: " +da.getData().get(i).getId());
			System.out.println("Data["+i+"] iGroup ID: " +da.getData().get(i).getInitiator_group_id());
			System.out.println("Data["+i+"] iGroup Name: " +da.getData().get(i).getInitiator_group_name());
		}

	}
	
	public ACRobject getResponseObject() {
		
		Gson gson = new Gson();
		
		ACRobject da = gson.fromJson(jsonText, ACRobject.class);
		
		return da;
	}

}


