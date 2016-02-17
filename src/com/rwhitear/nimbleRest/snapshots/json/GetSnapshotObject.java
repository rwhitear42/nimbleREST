package com.rwhitear.nimbleRest.snapshots.json;

import java.util.List;

public class GetSnapshotObject {
	
	private List<GetSnapshotDataObject> data;
	private int endRow;
	private int startRow;
	private int totalRows;
	
		
	public List<GetSnapshotDataObject> getData() {
		return data;
	}

	public void setData(List<GetSnapshotDataObject> data) {
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
	
	@Override
	public String toString() {		
		return 	"data: " + getData() + ",\n" + 
				"endRow: " + getEndRow() + ",\n" +
				"startRow: " + getStartRow() + ",\n" + 
				"totalRows: " + getTotalRows();
	}

}
