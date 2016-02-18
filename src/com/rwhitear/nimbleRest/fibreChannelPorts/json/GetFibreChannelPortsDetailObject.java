package com.rwhitear.nimbleRest.fibreChannelPorts.json;

import java.util.List;

public class GetFibreChannelPortsDetailObject {

	private String startRow;
	private String endRow;
	private String totalRows;
	private List<GetFibreChannelPortsDetailDataObject> data;
	
	
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

	public List<GetFibreChannelPortsDetailDataObject> getData() {
		return data;
	}

	public void setData(List<GetFibreChannelPortsDetailDataObject> data) {
		this.data = data;
	}

}
