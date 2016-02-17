package com.rwhitear.nimbleRest.snapshots.json;


import com.google.gson.Gson;


public class GetSnapshotDetailResponse {

	private String jsonText;
	
	//Constructor.
	public GetSnapshotDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public void outputJSON() {
		
		Gson gson = new Gson();
		
		GetSnapshotObject da = gson.fromJson(jsonText, GetSnapshotObject.class);
		
		System.out.println("Data: " +da.getData().get(0).toString());
		
		System.out.println("Data Size: " +da.toString());
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			System.out.println("Data["+i+"] Volume Name: " +da.getData().get(i).getVol_name());
			System.out.println("Data["+i+"] Snapshot ID: " +da.getData().get(i).getId());
			System.out.println("Data["+i+"] ACR size: " +da.getData().get(0).getAccess_control_records().size());
			System.out.println("Data["+i+"] ACR Access Protocol: " +da.getData().get(0).getAccess_control_records().get(0).getAccess_protocol());
		}
	}
	
	public String getSnapshotID(String snapShotName) {
		
		String snapID = null;
		
		Gson gson = new Gson();
		
		GetSnapshotObject da = gson.fromJson(jsonText, GetSnapshotObject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			if( da.getData().get(i).getName().equals(snapShotName) ) {
				
				return da.getData().get(i).getId();
				
			}
		}
		
		return snapID; 
	}
	
}





