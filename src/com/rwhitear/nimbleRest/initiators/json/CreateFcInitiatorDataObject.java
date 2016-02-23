package com.rwhitear.nimbleRest.initiators.json;

public class CreateFcInitiatorDataObject {

	private String access_protocol;
	private String initiator_group_id;
	private String alias;
	private String wwpn;
	
	
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getWwpn() {
		return wwpn;
	}

	public void setWwpn(String wwpn) {
		this.wwpn = wwpn;
	}
	
}
