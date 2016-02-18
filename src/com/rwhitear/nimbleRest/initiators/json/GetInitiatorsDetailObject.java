package com.rwhitear.nimbleRest.initiators.json;

import java.util.List;

public class GetInitiatorsDetailObject {
	
	private List<GetInitiatorsDetailDataObject> data;

	public List<GetInitiatorsDetailDataObject> getData() {
		return data;
	}

	public void setData(List<GetInitiatorsDetailDataObject> data) {
		this.data = data;
	}

}
