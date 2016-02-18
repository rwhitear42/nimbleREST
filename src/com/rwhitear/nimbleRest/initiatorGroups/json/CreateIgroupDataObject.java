package com.rwhitear.nimbleRest.initiatorGroups.json;

public class CreateIgroupDataObject {

	private String name;
	private String description;
	private String access_protocol;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAccess_protocol() {
		return access_protocol;
	}
	
	public void setAccess_protocol(String access_protocol) {
		this.access_protocol = access_protocol;
	}
	
}
