package com.rwhitear.nimbleRest.snapshots.json;

import java.util.List;

import com.google.gson.Gson;


public class GetSnapshotDetailResponse {

	private String jsonText;
	
	//Constructor.
	public GetSnapshotDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public void outputJSON() {
		
		Gson gson = new Gson();
		
		SnapshotObject da = gson.fromJson(jsonText, SnapshotObject.class);
		
		System.out.println("Data: " +da.getData().get(0).toString());
		
		System.out.println("Data Size: " +da.toString());
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			System.out.println("Data["+i+"] Volume Name: " +da.getData().get(i).getVol_name());
			System.out.println("Data["+i+"] Snapshot ID: " +da.getData().get(i).getId());
			System.out.println("Data["+i+"] ACR size: " +da.getData().get(0).getAccess_control_records().size());
			System.out.println("Data["+i+"] ACR Access Protocol: " +da.getData().get(0).getAccess_control_records().get(0).getAccess_protocol());
		}
	}
	
	public String getSnapshotID(String snapShotName) {
		
		String snapID = null;
		
		Gson gson = new Gson();
		
		SnapshotObject da = gson.fromJson(jsonText, SnapshotObject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			if( da.getData().get(i).getName().equals(snapShotName) ) {
				
				return da.getData().get(i).getId();
				
			}
		}
		
		return snapID; 
	}
	
}

class SnapshotObject {
	
	private List<SnapshotDataObject> data;
	private int endRow;
	private int startRow;
	private int totalRows;
	
		
	public List<SnapshotDataObject> getData() {
		return data;
	}

	public void setData(List<SnapshotDataObject> data) {
		this.data = data;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	@Override
	public String toString() {		
		return 	"data: " + getData() + ",\n" + 
				"endRow: " + getEndRow() + ",\n" +
				"startRow: " + getStartRow() + ",\n" + 
				"totalRows: " + getTotalRows();
	}
		
}


class SnapshotDataObject {
	
	private List<SnapshotAccessControlRecordsObject> access_control_records;
	private String app_uuid;
	private String description;
	private String id;
	private boolean is_replica;
	private boolean is_unmanaged;
	private int last_modified;
	private String metadata;
	private String name;
	private int new_data_compressed_bytes;
	private int new_data_uncompressed_bytes;
	private boolean new_data_valid;
	private String offline_reason;
	private boolean online;
	private String origin_name;
	private String replication_status;
	private String schedule_name;
	private String serial_number;
	private int size;
	private String snap_collection_id;
	private String snap_collection_name;
	private String target_name;
	private String vol_id;
	private String vol_name;
	private boolean writable;
	
	
	public List<SnapshotAccessControlRecordsObject> getAccess_control_records() {
		return access_control_records;
	}
	
	public void setAccess_control_records(List<SnapshotAccessControlRecordsObject> access_control_records) {
		this.access_control_records = access_control_records;
	}
	
	public String getApp_uuid() {
		return app_uuid;
	}
	
	public void setApp_uuid(String app_uuid) {
		this.app_uuid = app_uuid;
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
	
	public boolean isIs_replica() {
		return is_replica;
	}
	
	public void setIs_replica(boolean is_replica) {
		this.is_replica = is_replica;
	}
	
	public boolean isIs_unmanaged() {
		return is_unmanaged;
	}
	
	public void setIs_unmanaged(boolean is_unmanaged) {
		this.is_unmanaged = is_unmanaged;
	}
	
	public int getLast_modified() {
		return last_modified;
	}
	
	public void setLast_modified(int last_modified) {
		this.last_modified = last_modified;
	}
	
	public String getMetadata() {
		return metadata;
	}
	
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNew_data_compressed_bytes() {
		return new_data_compressed_bytes;
	}
	
	public void setNew_data_compressed_bytes(int new_data_compressed_bytes) {
		this.new_data_compressed_bytes = new_data_compressed_bytes;
	}
	
	public int getNew_data_uncompressed_bytes() {
		return new_data_uncompressed_bytes;
	}
	
	public void setNew_data_uncompressed_bytes(int new_data_uncompressed_bytes) {
		this.new_data_uncompressed_bytes = new_data_uncompressed_bytes;
	}
	
	public boolean isNew_data_valid() {
		return new_data_valid;
	}
	
	public void setNew_data_valid(boolean new_data_valid) {
		this.new_data_valid = new_data_valid;
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
	
	public String getOrigin_name() {
		return origin_name;
	}
	
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	
	public String getReplication_status() {
		return replication_status;
	}
	
	public void setReplication_status(String replication_status) {
		this.replication_status = replication_status;
	}
	
	public String getSchedule_name() {
		return schedule_name;
	}
	
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	
	public String getSerial_number() {
		return serial_number;
	}
	
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getSnap_collection_id() {
		return snap_collection_id;
	}
	
	public void setSnap_collection_id(String snap_collection_id) {
		this.snap_collection_id = snap_collection_id;
	}
	
	public String getSnap_collection_name() {
		return snap_collection_name;
	}
	
	public void setSnap_collection_name(String snap_collection_name) {
		this.snap_collection_name = snap_collection_name;
	}
	
	public String getTarget_name() {
		return target_name;
	}
	
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	
	public String getVol_id() {
		return vol_id;
	}
	
	public void setVol_id(String vol_id) {
		this.vol_id = vol_id;
	}
	
	public String getVol_name() {
		return vol_name;
	}
	
	public void setVol_name(String vol_name) {
		this.vol_name = vol_name;
	}
	
	public boolean isWritable() {
		return writable;
	}
	
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
	
	@Override
	public String toString() {		
		return 	getAccess_control_records() + ",\n" + getApp_uuid() + ",\n" +
				getDescription() + ",\n" + getId() + ",\n" + 
				isIs_replica() + ",\n" + isIs_unmanaged() + ",\n" + 
				getLast_modified() + ",\n" + getMetadata() + ",\n" + 
				getName() + ",\n" + getNew_data_compressed_bytes() + ",\n" + 
				isNew_data_valid() + ",\n" + getOffline_reason() + ",\n" + 
				isOnline() + ",\n" + getOrigin_name() + ",\n" + 
				getReplication_status() + ",\n" + getSchedule_name() + ",\n" + 
				getSerial_number() + ",\n" + getSize() + ",\n" + 
				getSnap_collection_id() + ",\n" + getSnap_collection_name() + ",\n" + 
				getTarget_name() + ",\n" + getVol_id() + ",\n" + 
				getVol_name() + ",\n" + isWritable();
	}
}

class SnapshotAccessControlRecordsObject {
	
	private String access_protocol;
	private String acl_id;
	private String apply_to;
	private String chap_user_id;
	private String chap_user_name;
	private String initiator_group_id;
	private String initiator_group_name;
	private String lun;
	
	
	public String getAccess_protocol() {
		return access_protocol;
	}
	public void setAccess_protocol(String access_protocol) {
		this.access_protocol = access_protocol;
	}
	public String getAcl_id() {
		return acl_id;
	}
	public void setAcl_id(String acl_id) {
		this.acl_id = acl_id;
	}
	public String getApply_to() {
		return apply_to;
	}
	public void setApply_to(String apply_to) {
		this.apply_to = apply_to;
	}
	public String getChap_user_id() {
		return chap_user_id;
	}
	public void setChap_user_id(String chap_user_id) {
		this.chap_user_id = chap_user_id;
	}
	public String getChap_user_name() {
		return chap_user_name;
	}
	public void setChap_user_name(String chap_user_name) {
		this.chap_user_name = chap_user_name;
	}
	public String getInitiator_group_id() {
		return initiator_group_id;
	}
	public void setInitiator_group_id(String initiator_group_id) {
		this.initiator_group_id = initiator_group_id;
	}
	public String getInitiator_group_name() {
		return initiator_group_name;
	}
	public void setInitiator_group_name(String initiator_group_name) {
		this.initiator_group_name = initiator_group_name;
	}
	public String getLun() {
		return lun;
	}
	public void setLun(String lun) {
		this.lun = lun;
	}

	@Override
	public String toString() {		
		return 	getAccess_protocol() + ",\n" + getAcl_id() + ",\n" +
				getApply_to() + ",\n" + getChap_user_id() + ",\n" +
				getChap_user_name() + ",\n" + getInitiator_group_id() + ",\n" + 
				getInitiator_group_name() + ",\n" + getLun();
	}
	
}

