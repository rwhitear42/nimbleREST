package com.rwhitear.nimbleRest.inventory.data;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataObject {
	
	private List<String>	arrayNames 			= new ArrayList<String>();
	private List<String> 	modelNames 			= new ArrayList<String>();
	private List<Long> 		volUsageBytes 		= new ArrayList<Long>();
	private List<Long> 		snapUsageBytes 		= new ArrayList<Long>();
	private List<Long> 		usableCapacityBytes	= new ArrayList<Long>();
	
	
	public List<String> getArrayNames() {
		return arrayNames;
	}
	
	public void setArrayNames(List<String> arrayNames) {
		this.arrayNames = arrayNames;
	}
	
	public List<String> getModelNames() {
		return modelNames;
	}
	
	public void setModelNames(List<String> modelNames) {
		this.modelNames = modelNames;
	}
	
	public List<Long> getVolUsageBytes() {
		return volUsageBytes;
	}
	
	public void setVolUsageBytes(List<Long> volUsageBytes) {
		this.volUsageBytes = volUsageBytes;
	}
	
	public List<Long> getSnapUsageBytes() {
		return snapUsageBytes;
	}
	
	public void setSnapUsageBytes(List<Long> snapUsageBytes) {
		this.snapUsageBytes = snapUsageBytes;
	}
	
	public List<Long> getUsableCapacityBytes() {
		return usableCapacityBytes;
	}
	
	public void setUsableCapacityBytes(List<Long> usableCapacityBytes) {
		this.usableCapacityBytes = usableCapacityBytes;
	}

}
