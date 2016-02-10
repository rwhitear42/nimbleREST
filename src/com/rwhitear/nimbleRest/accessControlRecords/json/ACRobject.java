package com.rwhitear.nimbleRest.accessControlRecords.json;

import java.util.List;

public class ACRobject {
		
	private List<ACRdataObject> data;
	private int endRow;
	private int startRow;
	private int totalRows;
	
	
	public List<ACRdataObject> getData() {
		return data;
	}
	
	public void setData(List<ACRdataObject> data) {
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

	