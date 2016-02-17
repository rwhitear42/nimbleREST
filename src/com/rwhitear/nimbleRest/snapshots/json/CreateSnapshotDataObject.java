package com.rwhitear.nimbleRest.snapshots.json;

public class CreateSnapshotDataObject {

	private String vol_id;
	private String name;
	private String description;
	private boolean writable;
	private boolean online;
	
	
	public String getVol_id() {
		return vol_id;
	}
	
	public void setVol_id(String vol_id) {
		this.vol_id = vol_id;
	}
	
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
	
	public boolean isWritable() {
		return writable;
	}
	
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
	
	public boolean isOnline() {
		return online;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
	
}
