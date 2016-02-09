package com.rwhitear.nimbleRest.initiatorGroups.json;

import java.util.List;

import com.google.gson.Gson;


public class GetInitiatorGroupsDetailResponse {

	private String jsonText;
	
	//Constructor.
	public GetInitiatorGroupsDetailResponse(String jsonText) {
		this.jsonText = jsonText;
	}

	public void outputJSON() {
		
		Gson gson = new Gson();
		
		InitiatorGroupObject da = gson.fromJson(jsonText, InitiatorGroupObject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			System.out.println("access_protocol["+i+"]: " + da.getData().get(i).getAccess_protocol());
			//System.out.println("fc_initiators["+i+"] size: " + da.getData().get(i).getFc_initiators().size());
			
			if( da.getData().get(i).getFc_initiators() == null ) {
				System.out.println("fc_initiators is empty");
			} else {
				System.out.println("fc_initiators["+i+"] size: " + da.getData().get(i).getFc_initiators().size());
			}
			
			if( da.getData().get(i).getIscsi_initiators() == null ) {
				System.out.println("iscsi_initiators is empty");
			} else {
				System.out.println("iscsi_initiators["+i+"] size: " + da.getData().get(i).getIscsi_initiators().size());
			}
			
			System.out.println("id["+i+"]: " + da.getData().get(i).getId());
			System.out.println("name["+i+"]: " + da.getData().get(i).getName());
		}

	}
	
	public String getInitiatorGroupID(String initiatorGroupName) {
		
		String initiatorGroupID = null;
		
		Gson gson = new Gson();
		
		InitiatorGroupObject da = gson.fromJson(jsonText, InitiatorGroupObject.class);
		
		for( int i = 0; i < da.getData().size(); i++ ) {
			
			if( da.getData().get(i).getName().equals(initiatorGroupName) ) {
				
				return da.getData().get(i).getId();
				
			}
		}
		
		return initiatorGroupID; 
	}
	
	
}


class InitiatorGroupObject {
	
	private List<InitiatorGroupDataObject> data;
	private int endRow;
	private int startRow;
	private int totalRows;
	
	
	public List<InitiatorGroupDataObject> getData() {
		return data;
	}
	
	public void setData(List<InitiatorGroupDataObject> data) {
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
	
	
	
}


class InitiatorGroupDataObject {
	
	private String access_protocol;
	private int creation_time;
	private String description;
	private List<FcInitiatorsObject> fc_initiators;
	private String full_name;
	private String id;
	private List<IscsiInitiatorsObject> iscsi_initiators;
	private int last_modified;
	private String name;
	private String search_name;
	private String target_subnets;
	
	
	public String getAccess_protocol() {
		return access_protocol;
	}
	
	public void setAccess_protocol(String access_protocol) {
		this.access_protocol = access_protocol;
	}
	
	public int getCreation_time() {
		return creation_time;
	}
	
	public void setCreation_time(int creation_time) {
		this.creation_time = creation_time;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<FcInitiatorsObject> getFc_initiators() {
		return fc_initiators;
	}
	
	public void setFc_initiators(List<FcInitiatorsObject> fc_initiators) {
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
	
	public List<IscsiInitiatorsObject> getIscsi_initiators() {
		return iscsi_initiators;
	}
	
	public void setIscsi_initiators(List<IscsiInitiatorsObject> iscsi_initiators) {
		this.iscsi_initiators = iscsi_initiators;
	}
	
	public int getLast_modified() {
		return last_modified;
	}
	
	public void setLast_modified(int last_modified) {
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
	
	public String getTarget_subnets() {
		return target_subnets;
	}
	
	public void setTarget_subnets(String target_subnets) {
		this.target_subnets = target_subnets;
	}
	
}


class FcInitiatorsObject {
	
	// Need to test to an FC array and then populate this class with values.
	
}


class IscsiInitiatorsObject {
	
	private String initiator_id;
	private String ip_address;
	private String iqn;
	private String label;
	
	
	public String getInitiator_id() {
		return initiator_id;
	}
	
	public void setInitiator_id(String initiator_id) {
		this.initiator_id = initiator_id;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	public String getIqn() {
		return iqn;
	}
	
	public void setIqn(String iqn) {
		this.iqn = iqn;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
}