package com.rwhitear.nimbleRest.inventory.data;

import java.util.ArrayList;
import java.util.List;

public class VolumeDataObject {
	
	private List<String> volNames = new ArrayList<String>();
	private List<Long> volSizes = new ArrayList<Long>();
	private List<Long> volUsageCompressedBytes = new ArrayList<Long>();
	private List<Long> snapUsageCompressedBytes = new ArrayList<Long>();
	private List<Long> totalUsageBytes = new ArrayList<Long>();
	

	public List<Long> getTotalUsageBytes() {
		return totalUsageBytes;
	}

	public void setTotalUsageBytes(List<Long> totalUsageBytes) {
		this.totalUsageBytes = totalUsageBytes;
	}

	public List<Long> getVolUsageCompressedBytes() {
		return volUsageCompressedBytes;
	}

	public void setVolUsageCompressedBytes(List<Long> volUsageCompressedBytes) {
		this.volUsageCompressedBytes = volUsageCompressedBytes;
	}

	public List<Long> getSnapUsageCompressedBytes() {
		return snapUsageCompressedBytes;
	}

	public void setSnapUsageCompressedBytes(List<Long> snapUsageCompressedBytes) {
		this.snapUsageCompressedBytes = snapUsageCompressedBytes;
	}

	public List<String> getVolNames() {
		return volNames;
	}

	public void setVolNames(List<String> volNames) {
		this.volNames = volNames;
	}

	public List<Long> getVolSizes() {
		return volSizes;
	}

	public void setVolSizes(List<Long> volSizes) {
		this.volSizes = volSizes;
	}

}
