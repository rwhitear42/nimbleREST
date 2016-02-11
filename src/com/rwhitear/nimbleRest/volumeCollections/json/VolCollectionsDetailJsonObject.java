package com.rwhitear.nimbleRest.volumeCollections.json;

import java.util.List;


public class VolCollectionsDetailJsonObject {

	private int startRow;
	private int endRow;
	private int totalRows;
	private List<VolCollectionsDetailDataJsonObject> data;
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
	public List<VolCollectionsDetailDataJsonObject> getData() {
		return data;
	}
	public void setData(List<VolCollectionsDetailDataJsonObject> data) {
		this.data = data;
	}

}
