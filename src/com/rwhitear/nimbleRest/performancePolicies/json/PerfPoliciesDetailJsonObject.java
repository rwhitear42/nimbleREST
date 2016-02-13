package com.rwhitear.nimbleRest.performancePolicies.json;

import java.util.List;


public class PerfPoliciesDetailJsonObject {

	private int startRow;
	private int endRow;
	private int totalRows;
	private List<PerfPoliciesDetailDataJsonObject> data;
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
	public List<PerfPoliciesDetailDataJsonObject> getData() {
		return data;
	}
	public void setData(List<PerfPoliciesDetailDataJsonObject> data) {
		this.data = data;
	}

}
