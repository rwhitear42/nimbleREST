package com.rwhitear.nimbleRest.performancePolicies.json;

public class PerfPoliciesDetailDataJsonObject {

	private long block_size;
	private boolean cache;
	private String cache_policy;
	private boolean compress;
	private long creation_time;
	private String description;
	private String full_name;
	private String id;
	private long last_modified;
	private String name;
	private String search_name;
	private String space_policy;
	
	
	public long getBlock_size() {
		return block_size;
	}
	
	public void setBlock_size(long block_size) {
		this.block_size = block_size;
	}
	
	public boolean isCache() {
		return cache;
	}
	
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	
	public String getCache_policy() {
		return cache_policy;
	}
	
	public void setCache_policy(String cache_policy) {
		this.cache_policy = cache_policy;
	}
	
	public boolean isCompress() {
		return compress;
	}
	
	public void setCompress(boolean compress) {
		this.compress = compress;
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
	
	public String getSpace_policy() {
		return space_policy;
	}
	
	public void setSpace_policy(String space_policy) {
		this.space_policy = space_policy;
	}
	
}
