package com.rwhitear.nimbleRest.initiatorGroups.json;

import java.util.List;


public class GetInitiatorGroupsDetailObject {

	private String startRow;
	private String endRow;
	private String totalRows;
	private List<GetInitiatorGroupsDetailDataObject> data;
	
	
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
	
	public List<GetInitiatorGroupsDetailDataObject> getData() {
		return data;
	}
	
	public void setData(List<GetInitiatorGroupsDetailDataObject> data) {
		this.data = data;
	}

}
