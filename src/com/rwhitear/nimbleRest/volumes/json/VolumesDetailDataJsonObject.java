package com.rwhitear.nimbleRest.volumes.json;

import java.util.List;

public class VolumesDetailDataJsonObject {
	
	private List<VolumesDetailDataACRJsonObject> access_control_records;
	private String agent_type;
	private String app_uuid;
	private String base_snap_id;
	private String base_snap_name;
	private long block_size;
	private long cache_needed_for_pin;
	private boolean cache_pinned;
	private String cache_policy;
	private boolean caching_enabled;
	private boolean clone;
	private long creation_time;
	private String description;
	private String dest_pool_id;
	private String dest_pool_name;
	private String encryption_cipher;
	private List<VolumesDetailDataFCsessJsonObject> fc_sessions;
	private String full_name;
	private String id;
	private List<VolumesDetailDataIscsiSessJsonObject> iscsi_sessions;
	private long last_modified;
	private long limit;
	private List<VolumesDetailDataMetadataJsonObject> metadata;
	private boolean move_aborting;
	private long move_bytes_migrated;
	private long move_bytes_remaining;
	private long move_start_time;
	private boolean multi_initiator;
	private String name;
	private long num_connections;
	private long num_fc_connections;
	private long num_iscsi_connections;
	private long num_snaps;
	private String offline_reason;
	private boolean online;
	private List<VolumesDetailDataOnlineSnapsJsonObject> online_snaps;
	private String owned_by_group;
	private String parent_vol_id;
	private String parent_vol_name;
	private String perfpolicy_id;
	private String perfpolicy_name;
	private long pinned_cache_size;
	private String pool_id;
	private String pool_name;
	private long projected_num_snaps;
	private boolean read_only;
	private long reserve;
	private String search_name;
	private String serial_number;
	private long size;
	private long snap_limit;
	private long snap_reserve;
	private long snap_usage_compressed_bytes;
	private long snap_usage_populated_bytes;
	private long snap_usage_uncompressed_bytes;
	private long snap_warn_level;
	private String target_name;
	private boolean thinly_provisioned;
	private boolean upstream_cache_pinned;
	private boolean usage_valid;
	private String vol_state;
	private long vol_usage_compressed_bytes;
	private long vol_usage_uncompressed_bytes;
	private String volcoll_id;
	private String volcoll_name;
	private int warn_level;
	
	
	public List<VolumesDetailDataACRJsonObject> getAccess_control_records() {
		return access_control_records;
	}
	public void setAccess_control_records(List<VolumesDetailDataACRJsonObject> access_control_records) {
		this.access_control_records = access_control_records;
	}
	public String getAgent_type() {
		return agent_type;
	}
	public void setAgent_type(String agent_type) {
		this.agent_type = agent_type;
	}
	public String getApp_uuid() {
		return app_uuid;
	}
	public void setApp_uuid(String app_uuid) {
		this.app_uuid = app_uuid;
	}
	public String getBase_snap_id() {
		return base_snap_id;
	}
	public void setBase_snap_id(String base_snap_id) {
		this.base_snap_id = base_snap_id;
	}
	public String getBase_snap_name() {
		return base_snap_name;
	}
	public void setBase_snap_name(String base_snap_name) {
		this.base_snap_name = base_snap_name;
	}
	public long getBlock_size() {
		return block_size;
	}
	public void setBlock_size(long block_size) {
		this.block_size = block_size;
	}
	public long getCache_needed_for_pin() {
		return cache_needed_for_pin;
	}
	public void setCache_needed_for_pin(long cache_needed_for_pin) {
		this.cache_needed_for_pin = cache_needed_for_pin;
	}
	public boolean isCache_pinned() {
		return cache_pinned;
	}
	public void setCache_pinned(boolean cache_pinned) {
		this.cache_pinned = cache_pinned;
	}
	public String getCache_policy() {
		return cache_policy;
	}
	public void setCache_policy(String cache_policy) {
		this.cache_policy = cache_policy;
	}
	public boolean isCaching_enabled() {
		return caching_enabled;
	}
	public void setCaching_enabled(boolean caching_enabled) {
		this.caching_enabled = caching_enabled;
	}
	public boolean isClone() {
		return clone;
	}
	public void setClone(boolean clone) {
		this.clone = clone;
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
	public String getDest_pool_id() {
		return dest_pool_id;
	}
	public void setDest_pool_id(String dest_pool_id) {
		this.dest_pool_id = dest_pool_id;
	}
	public String getDest_pool_name() {
		return dest_pool_name;
	}
	public void setDest_pool_name(String dest_pool_name) {
		this.dest_pool_name = dest_pool_name;
	}
	public String getEncryption_cipher() {
		return encryption_cipher;
	}
	public void setEncryption_cipher(String encryption_cipher) {
		this.encryption_cipher = encryption_cipher;
	}
	public List<VolumesDetailDataFCsessJsonObject> getFc_sessions() {
		return fc_sessions;
	}
	public void setFc_sessions(List<VolumesDetailDataFCsessJsonObject> fc_sessions) {
		this.fc_sessions = fc_sessions;
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
	public List<VolumesDetailDataIscsiSessJsonObject> getIscsi_sessions() {
		return iscsi_sessions;
	}
	public void setIscsi_sessions(List<VolumesDetailDataIscsiSessJsonObject> iscsi_sessions) {
		this.iscsi_sessions = iscsi_sessions;
	}
	public long getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(long last_modified) {
		this.last_modified = last_modified;
	}
	public long getLimit() {
		return limit;
	}
	public void setLimit(long limit) {
		this.limit = limit;
	}
	public List<VolumesDetailDataMetadataJsonObject> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<VolumesDetailDataMetadataJsonObject> metadata) {
		this.metadata = metadata;
	}
	public boolean isMove_aborting() {
		return move_aborting;
	}
	public void setMove_aborting(boolean move_aborting) {
		this.move_aborting = move_aborting;
	}
	public long getMove_bytes_migrated() {
		return move_bytes_migrated;
	}
	public void setMove_bytes_migrated(long move_bytes_migrated) {
		this.move_bytes_migrated = move_bytes_migrated;
	}
	public long getMove_bytes_remaining() {
		return move_bytes_remaining;
	}
	public void setMove_bytes_remaining(long move_bytes_remaining) {
		this.move_bytes_remaining = move_bytes_remaining;
	}
	public long getMove_start_time() {
		return move_start_time;
	}
	public void setMove_start_time(long move_start_time) {
		this.move_start_time = move_start_time;
	}
	public boolean isMulti_initiator() {
		return multi_initiator;
	}
	public void setMulti_initiator(boolean multi_initiator) {
		this.multi_initiator = multi_initiator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNum_connections() {
		return num_connections;
	}
	public void setNum_connections(long num_connections) {
		this.num_connections = num_connections;
	}
	public long getNum_fc_connections() {
		return num_fc_connections;
	}
	public void setNum_fc_connections(long num_fc_connections) {
		this.num_fc_connections = num_fc_connections;
	}
	public long getNum_iscsi_connections() {
		return num_iscsi_connections;
	}
	public void setNum_iscsi_connections(long num_iscsi_connections) {
		this.num_iscsi_connections = num_iscsi_connections;
	}
	public long getNum_snaps() {
		return num_snaps;
	}
	public void setNum_snaps(long num_snaps) {
		this.num_snaps = num_snaps;
	}
	public String getOffline_reason() {
		return offline_reason;
	}
	public void setOffline_reason(String offline_reason) {
		this.offline_reason = offline_reason;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public List<VolumesDetailDataOnlineSnapsJsonObject> getOnline_snaps() {
		return online_snaps;
	}
	public void setOnline_snaps(List<VolumesDetailDataOnlineSnapsJsonObject> online_snaps) {
		this.online_snaps = online_snaps;
	}
	public String getOwned_by_group() {
		return owned_by_group;
	}
	public void setOwned_by_group(String owned_by_group) {
		this.owned_by_group = owned_by_group;
	}
	public String getParent_vol_id() {
		return parent_vol_id;
	}
	public void setParent_vol_id(String parent_vol_id) {
		this.parent_vol_id = parent_vol_id;
	}
	public String getParent_vol_name() {
		return parent_vol_name;
	}
	public void setParent_vol_name(String parent_vol_name) {
		this.parent_vol_name = parent_vol_name;
	}
	public String getPerfpolicy_id() {
		return perfpolicy_id;
	}
	public void setPerfpolicy_id(String perfpolicy_id) {
		this.perfpolicy_id = perfpolicy_id;
	}
	public String getPerfpolicy_name() {
		return perfpolicy_name;
	}
	public void setPerfpolicy_name(String perfpolicy_name) {
		this.perfpolicy_name = perfpolicy_name;
	}
	public long getPinned_cache_size() {
		return pinned_cache_size;
	}
	public void setPinned_cache_size(long pinned_cache_size) {
		this.pinned_cache_size = pinned_cache_size;
	}
	public String getPool_id() {
		return pool_id;
	}
	public void setPool_id(String pool_id) {
		this.pool_id = pool_id;
	}
	public String getPool_name() {
		return pool_name;
	}
	public void setPool_name(String pool_name) {
		this.pool_name = pool_name;
	}
	public long getProjected_num_snaps() {
		return projected_num_snaps;
	}
	public void setProjected_num_snaps(long projected_num_snaps) {
		this.projected_num_snaps = projected_num_snaps;
	}
	public boolean isRead_only() {
		return read_only;
	}
	public void setRead_only(boolean read_only) {
		this.read_only = read_only;
	}
	public long getReserve() {
		return reserve;
	}
	public void setReserve(long reserve) {
		this.reserve = reserve;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getSnap_limit() {
		return snap_limit;
	}
	public void setSnap_limit(long snap_limit) {
		this.snap_limit = snap_limit;
	}
	public long getSnap_reserve() {
		return snap_reserve;
	}
	public void setSnap_reserve(long snap_reserve) {
		this.snap_reserve = snap_reserve;
	}
	public long getSnap_usage_compressed_bytes() {
		return snap_usage_compressed_bytes;
	}
	public void setSnap_usage_compressed_bytes(long snap_usage_compressed_bytes) {
		this.snap_usage_compressed_bytes = snap_usage_compressed_bytes;
	}
	public long getSnap_usage_populated_bytes() {
		return snap_usage_populated_bytes;
	}
	public void setSnap_usage_populated_bytes(long snap_usage_populated_bytes) {
		this.snap_usage_populated_bytes = snap_usage_populated_bytes;
	}
	public long getSnap_usage_uncompressed_bytes() {
		return snap_usage_uncompressed_bytes;
	}
	public void setSnap_usage_uncompressed_bytes(long snap_usage_uncompressed_bytes) {
		this.snap_usage_uncompressed_bytes = snap_usage_uncompressed_bytes;
	}
	public long getSnap_warn_level() {
		return snap_warn_level;
	}
	public void setSnap_warn_level(long snap_warn_level) {
		this.snap_warn_level = snap_warn_level;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public boolean isThinly_provisioned() {
		return thinly_provisioned;
	}
	public void setThinly_provisioned(boolean thinly_provisioned) {
		this.thinly_provisioned = thinly_provisioned;
	}
	public boolean isUpstream_cache_pinned() {
		return upstream_cache_pinned;
	}
	public void setUpstream_cache_pinned(boolean upstream_cache_pinned) {
		this.upstream_cache_pinned = upstream_cache_pinned;
	}
	public boolean isUsage_valid() {
		return usage_valid;
	}
	public void setUsage_valid(boolean usage_valid) {
		this.usage_valid = usage_valid;
	}
	public String getVol_state() {
		return vol_state;
	}
	public void setVol_state(String vol_state) {
		this.vol_state = vol_state;
	}
	public long getVol_usage_compressed_bytes() {
		return vol_usage_compressed_bytes;
	}
	public void setVol_usage_compressed_bytes(long vol_usage_compressed_bytes) {
		this.vol_usage_compressed_bytes = vol_usage_compressed_bytes;
	}
	public long getVol_usage_uncompressed_bytes() {
		return vol_usage_uncompressed_bytes;
	}
	public void setVol_usage_uncompressed_bytes(long vol_usage_uncompressed_bytes) {
		this.vol_usage_uncompressed_bytes = vol_usage_uncompressed_bytes;
	}
	public String getVolcoll_id() {
		return volcoll_id;
	}
	public void setVolcoll_id(String volcoll_id) {
		this.volcoll_id = volcoll_id;
	}
	public String getVolcoll_name() {
		return volcoll_name;
	}
	public void setVolcoll_name(String volcoll_name) {
		this.volcoll_name = volcoll_name;
	}
	public int getWarn_level() {
		return warn_level;
	}
	public void setWarn_level(int warn_level) {
		this.warn_level = warn_level;
	}
	
	
}
