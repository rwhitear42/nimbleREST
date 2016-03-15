package com.rwhitear.nimbleRest.inventory.data;

import java.util.ArrayList;
import java.util.List;

public class PerformancePolicyDataObject {
	
	private List<String> perfPolicyNames = new ArrayList<String>();
	private List<Integer> associatedVolumes = new ArrayList<Integer>();
	
	public List<String> getPerfPolicyNames() {
		return perfPolicyNames;
	}
	
	public void setPerfPolicyNames(List<String> perfPolicyNames) {
		this.perfPolicyNames = perfPolicyNames;
	}
	
	public List<Integer> getAssociatedVolumes() {
		return associatedVolumes;
	}
	
	public void setAssociatedVolumes(List<Integer> associatedVolumes) {
		this.associatedVolumes = associatedVolumes;
	}

}
