package com.rwhitear.nimbleRest.subnets.json;

import java.util.List;

public class GetSubnetsDetailObject {

	private String startRow;
	private String endRow;
	private String totalRows;
	private List<GetSubnetsDetailDataObject> data;
	
	
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
	
	public List<GetSubnetsDetailDataObject> getData() {
		return data;
	}
	
	public void setData(List<GetSubnetsDetailDataObject> data) {
		this.data = data;
	}

}
