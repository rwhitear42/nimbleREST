package com.rwhitear.nimbleRest.volumes.json;

import java.util.List;

import com.google.gson.Gson;


public class GetVolumesSummaryResponse {
	
	private String jsonText;
	
	
	// Constructors.
	public GetVolumesSummaryResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public void outputJSON() {
		
		Gson gson = new Gson();
		
		DataObject da = gson.fromJson(jsonText, DataObject.class);
		
	
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			System.out.println("data.size("+i+"): " +da.getData().get(i).getName());
			
		}
		
		System.out.println("End Row: " +da.getEndRow());
		
	}
	
	public String getVolumeID(String volumeName) {
		
		String volumeID = null;
		
		Gson gson = new Gson();
		
		DataObject da = gson.fromJson(jsonText, DataObject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			String volName = da.getData().get(i).getName();
			
			//System.out.println("Comparing " +volName+ " with " +volumeName);
			
			if( volName.equals(volumeName) ) {
				
				//System.out.println("Found volume " +volName );
				
				return da.getData().get(i).getId();
			}
			
		}
		
		return volumeID;
	}
}

class DataObject {
	
	private int endRow;
	private int startRow;
	private int totalRows;
	private List<VolumeSummaryObject> data;
	
	
	public List<VolumeSummaryObject> getData() {
		return data;
	}

	public void setData(List<VolumeSummaryObject> data) {
		this.data = data;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	
	
}

class VolumeSummaryObject {
	
	private String id;
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {		
		return getId() + ", " + getName();		
	}
	
}
