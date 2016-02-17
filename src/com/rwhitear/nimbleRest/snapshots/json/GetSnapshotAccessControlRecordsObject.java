package com.rwhitear.nimbleRest.snapshots.json;

public class GetSnapshotAccessControlRecordsObject {

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
