package com.rwhitear.nimbleRest.volumeCollections.json;

import java.util.List;

public class VolCollectionsDetailDataJsonObject {

	private String app_cluster_name;
	private String app_id;
	private String app_server;
	private String app_service_name;
	private String app_sync;
	private long creation_time;
	private String description;
	private String full_name;
	private String id;
	private long last_modified_time;
	private String name;
	private String pol_owner_name;
	private List<VolCollectionsDetailDataScheduleList> schedule_list;
	private String search_name;
	private long snapcoll_count;
	private String vcenter_hostname;
	private String vcenter_password;
	private String vcenter_username;
	private List<VolCollectionsDetailDataVolumeList> volume_list;
	
	
	public String getApp_cluster_name() {
		return app_cluster_name;
	}
	public void setApp_cluster_name(String app_cluster_name) {
		this.app_cluster_name = app_cluster_name;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getApp_server() {
		return app_server;
	}
	public void setApp_server(String app_server) {
		this.app_server = app_server;
	}
	public String getApp_service_name() {
		return app_service_name;
	}
	public void setApp_service_name(String app_service_name) {
		this.app_service_name = app_service_name;
	}
	public String getApp_sync() {
		return app_sync;
	}
	public void setApp_sync(String app_sync) {
		this.app_sync = app_sync;
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
	public long getLast_modified_time() {
		return last_modified_time;
	}
	public void setLast_modified_time(long last_modified_time) {
		this.last_modified_time = last_modified_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPol_owner_name() {
		return pol_owner_name;
	}
	public void setPol_owner_name(String pol_owner_name) {
		this.pol_owner_name = pol_owner_name;
	}
	public List<VolCollectionsDetailDataScheduleList> getSchedule_list() {
		return schedule_list;
	}
	public void setSchedule_list(List<VolCollectionsDetailDataScheduleList> schedule_list) {
		this.schedule_list = schedule_list;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public long getSnapcoll_count() {
		return snapcoll_count;
	}
	public void setSnapcoll_count(long snapcoll_count) {
		this.snapcoll_count = snapcoll_count;
	}
	public String getVcenter_hostname() {
		return vcenter_hostname;
	}
	public void setVcenter_hostname(String vcenter_hostname) {
		this.vcenter_hostname = vcenter_hostname;
	}
	public String getVcenter_password() {
		return vcenter_password;
	}
	public void setVcenter_password(String vcenter_password) {
		this.vcenter_password = vcenter_password;
	}
	public String getVcenter_username() {
		return vcenter_username;
	}
	public void setVcenter_username(String vcenter_username) {
		this.vcenter_username = vcenter_username;
	}
	public List<VolCollectionsDetailDataVolumeList> getVolume_list() {
		return volume_list;
	}
	public void setVolume_list(List<VolCollectionsDetailDataVolumeList> volume_list) {
		this.volume_list = volume_list;
	}
	
}
