package com.rwhitear.nimbleRest.arrays.json;

import java.util.List;

public class GetArraysDetailObject {

	private String startRow;
	private String endRow;
	private String totalRows;
	private List<GetArraysDetailDataObject> data;
	
	
	public String getStartRow() {
		return startRow;
	}
	
	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}
	
	public String getEndRow() {
		return endRow;
	}
	
	public void setEndRow(String endRow) {
		this.endRow = endRow;
	}
	
	public String getTotalRows() {
		return totalRows;
	}
	
	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}
	
	public List<GetArraysDetailDataObject> getData() {
		return data;
	}
	
	public void setData(List<GetArraysDetailDataObject> data) {
		this.data = data;
	}
	
}
