package com.rwhitear.nimbleRest.volumes.json;

public class CreateVolumeDataObject {

	private String name;
	private String size;
	private String description;
	private String perfpolicy_id;
	private String encryption_cipher;
	private boolean cache_pinned;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPerfpolicy_id() {
		return perfpolicy_id;
	}
	
	public void setPerfpolicy_id(String perfpolicy_id) {
		this.perfpolicy_id = perfpolicy_id;
	}
	
	public String getEncryption_cipher() {
		return encryption_cipher;
	}
	
	public void setEncryption_cipher(String encryption_cipher) {
		this.encryption_cipher = encryption_cipher;
	}
	
	public boolean isCache_pinned() {
		return cache_pinned;
	}
	
	public void setCache_pinned(boolean cache_pinned) {
		this.cache_pinned = cache_pinned;
	}
	
}
