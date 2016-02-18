package com.rwhitear.nimbleRest.subnets.json;

public class GetSubnetsDetailDataObject {
	
	private boolean allow_group;
	private boolean allow_iscsi;
	private long creation_time;
	private String discovery_ip;
	private String id;
	private long last_modified;
	private int mtu;
	private String name;
	private String netmask;
	private String network;
	private String netzone_type;
	private String type;
	private int vlan_id;
	
	
	public boolean isAllow_group() {
		return allow_group;
	}
	
	public void setAllow_group(boolean allow_group) {
		this.allow_group = allow_group;
	}
	
	public boolean isAllow_iscsi() {
		return allow_iscsi;
	}
	
	public void setAllow_iscsi(boolean allow_iscsi) {
		this.allow_iscsi = allow_iscsi;
	}
	
	public long getCreation_time() {
		return creation_time;
	}
	
	public void setCreation_time(long creation_time) {
		this.creation_time = creation_time;
	}
	
	public String getDiscovery_ip() {
		return discovery_ip;
	}
	
	public void setDiscovery_ip(String discovery_ip) {
		this.discovery_ip = discovery_ip;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getLast_modified() {
		return last_modified;
	}
	
	public void setLast_modified(long last_modified) {
		this.last_modified = last_modified;
	}
	
	public int getMtu() {
		return mtu;
	}
	
	public void setMtu(int mtu) {
		this.mtu = mtu;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNetmask() {
		return netmask;
	}
	
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	
	public String getNetwork() {
		return network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
	
	public String getNetzone_type() {
		return netzone_type;
	}
	
	public void setNetzone_type(String netzone_type) {
		this.netzone_type = netzone_type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getVlan_id() {
		return vlan_id;
	}
	
	public void setVlan_id(int vlan_id) {
		this.vlan_id = vlan_id;
	}

}
