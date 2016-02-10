package com.rwhitear.nimbleRest.accessControlRecords.json;

public class CreateACRdataObject {

	private String apply_to;
	private String initiator_group_id;
	private String vol_id;
	
	public CreateACRdataObject() {
		
	}
	
	public String getApply_to() {
		return apply_to;
	}
	
	public void setApply_to(String apply_to) {
		this.apply_to = apply_to;
	}
	
	public String getInitiator_group_id() {
		return initiator_group_id;
	}
	
	public void setInitiator_group_id(String initiator_group_id) {
		this.initiator_group_id = initiator_group_id;
	}
	
	public String getVol_id() {
		return vol_id;
	}
	
	public void setVol_id(String vol_id) {
		this.vol_id = vol_id;
	}
	
}
