package com.rwhitear.nimbleRest.initiatorGroups.json;

import java.util.List;

public class GetInitiatorGroupsDetailDataObject {

	private String access_protocol;
	private long creation_time;
	private String description;
	private List<GetInitiatorGroupsDetailFcInitiatorsObject> fc_initiators;
	private String full_name;
	private String id;
	private List<GetInitiatorGroupsDetailIscsiInitiatorsObject> iscsi_initiators;
	private long last_modified;
	private String name;
	private String search_name;
	private List<GetInitiatorGroupsDetailTargetSubnets> target_subnets;
	
	
	public String getAccess_protocol() {
		return access_protocol;
	}
	
	public void setAccess_protocol(String access_protocol) {
		this.access_protocol = access_protocol;
	}
	
	public long getCreation_time() {
		return creation_time;
	}
	
	public void setCreation_time(long creation_time) {
		this.creation_time = creation_time;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<GetInitiatorGroupsDetailFcInitiatorsObject> getFc_initiators() {
		return fc_initiators;
	}
	
	public void setFc_initiators(List<GetInitiatorGroupsDetailFcInitiatorsObject> fc_initiators) {
		this.fc_initiators = fc_initiators;
	}
	
	public String getFull_name() {
		return full_name;
	}
	
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<GetInitiatorGroupsDetailIscsiInitiatorsObject> getIscsi_initiators() {
		return iscsi_initiators;
	}
	
	public void setIscsi_initiators(List<GetInitiatorGroupsDetailIscsiInitiatorsObject> iscsi_initiators) {
		this.iscsi_initiators = iscsi_initiators;
	}
	
	public long getLast_modified() {
		return last_modified;
	}
	
	public void setLast_modified(long last_modified) {
		this.last_modified = last_modified;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSearch_name() {
		return search_name;
	}
	
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	
	public List<GetInitiatorGroupsDetailTargetSubnets> getTarget_subnets() {
		return target_subnets;
	}
	
	public void setTarget_subnets(List<GetInitiatorGroupsDetailTargetSubnets> target_subnets) {
		this.target_subnets = target_subnets;
	}
	
}
