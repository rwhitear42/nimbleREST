package com.rwhitear.nimbleRest.initiatorGroups.json;

public class GetInitiatorGroupsDetailIscsiInitiatorsObject {
	
	private String initiator_id;
	private String ip_address;
	private String iqn;
	private String label;
	
	
	public String getInitiator_id() {
		return initiator_id;
	}
	
	public void setInitiator_id(String initiator_id) {
		this.initiator_id = initiator_id;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	public String getIqn() {
		return iqn;
	}
	
	public void setIqn(String iqn) {
		this.iqn = iqn;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

}
