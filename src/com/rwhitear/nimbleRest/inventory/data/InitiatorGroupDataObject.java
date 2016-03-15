package com.rwhitear.nimbleRest.inventory.data;

import java.util.ArrayList;
import java.util.List;

public class InitiatorGroupDataObject {
	
	private List<String> initiatorGroupNames = new ArrayList<String>();

	public List<String> getInitiatorGroupNames() {
		return initiatorGroupNames;
	}

	public void setInitiatorGroupNames(List<String> initiatorGroupNames) {
		this.initiatorGroupNames = initiatorGroupNames;
	}

}
