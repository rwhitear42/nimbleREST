package com.rwhitear.nimbleRest.initiators.json;

public class CreateIscsiInitiatorDataObject {

	private String access_protocol;
	private String initiator_group_id;
	private String label;
	private String iqn;
	
	
	public String getAccess_protocol() {
		return access_protocol;
	}
	
	public void setAccess_protocol(String access_protocol) {
		this.access_protocol = access_protocol;
	}
	
	public String getInitiator_group_id() {
		return initiator_group_id;
	}
	
	public void setInitiator_group_id(String initiator_group_id) {
		this.initiator_group_id = initiator_group_id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getIqn() {
		return iqn;
	}
	
	public void setIqn(String iqn) {
		this.iqn = iqn;
	}

}
