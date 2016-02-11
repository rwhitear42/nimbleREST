package com.rwhitear.nimbleRest.volumes.json;

import java.util.List;

public class VolumesDetailJsonObject {

	private int startRow;
	private int endRow;
	private int totalRows;
	private List<VolumesDetailDataJsonObject> data;
	
	public int getStartRow() {
		return startRow;
	}
	
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	public int getEndRow() {
		return endRow;
	}
	
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	public List<VolumesDetailDataJsonObject> getData() {
		return data;
	}
	
	public void setData(List<VolumesDetailDataJsonObject> data) {
		this.data = data;
	}
	
}



