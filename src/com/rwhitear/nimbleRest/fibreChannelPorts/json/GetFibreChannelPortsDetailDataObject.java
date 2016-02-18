package com.rwhitear.nimbleRest.fibreChannelPorts.json;

public class GetFibreChannelPortsDetailDataObject {
	
	private String array_id;
	private String array_name;
	private String bus_location;
	private String controller_name;
	private long creation_time;
	private String description;
	private String id;
	private long last_modified;
	private String name;
	private boolean online;
	
	
	public String getArray_id() {
		return array_id;
	}
	
	public void setArray_id(String array_id) {
		this.array_id = array_id;
	}
	
	public String getArray_name() {
		return array_name;
	}
	
	public void setArray_name(String array_name) {
		this.array_name = array_name;
	}
	
	public String getBus_location() {
		return bus_location;
	}
	
	public void setBus_location(String bus_location) {
		this.bus_location = bus_location;
	}
	
	public String getController_name() {
		return controller_name;
	}
	
	public void setController_name(String controller_name) {
		this.controller_name = controller_name;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isOnline() {
		return online;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
	
}
