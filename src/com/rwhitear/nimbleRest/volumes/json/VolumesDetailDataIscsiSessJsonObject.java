package com.rwhitear.nimbleRest.volumes.json;

public class VolumesDetailDataIscsiSessJsonObject {
	
	private String initiator_id;
	private String initiator_ip_addr;
	private String initiator_name;
	private long num_connections;
	private long pr_key;
	private String target_ip_addr;
	
	
	public String getInitiator_id() {
		return initiator_id;
	}
	
	public void setInitiator_id(String initiator_id) {
		this.initiator_id = initiator_id;
	}
	
	public String getInitiator_ip_addr() {
		return initiator_ip_addr;
	}
	
	public void setInitiator_ip_addr(String initiator_ip_addr) {
		this.initiator_ip_addr = initiator_ip_addr;
	}
	
	public String getInitiator_name() {
		return initiator_name;
	}
	
	public void setInitiator_name(String initiator_name) {
		this.initiator_name = initiator_name;
	}
	
	public long getNum_connections() {
		return num_connections;
	}
	
	public void setNum_connections(long num_connections) {
		this.num_connections = num_connections;
	}
	
	public long getPr_key() {
		return pr_key;
	}
	
	public void setPr_key(long pr_key) {
		this.pr_key = pr_key;
	}
	
	public String getTarget_ip_addr() {
		return target_ip_addr;
	}
	
	public void setTarget_ip_addr(String target_ip_addr) {
		this.target_ip_addr = target_ip_addr;
	}

}