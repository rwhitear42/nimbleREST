package com.rwhitear.nimbleRest.inventory.data;

import java.util.ArrayList;
import java.util.List;

public class VolumeCollectionsDataObject {
	
	private List<String> 	volCollectionNames 	= new ArrayList<String>();
	private List<String> 	synchronization 	= new ArrayList<String>();
	private List<String> 	lastSnapshot		= new ArrayList<String>();
	private List<String> 	replicationPartner 	= new ArrayList<String>();
	private List<String> 	lastReplication 	= new ArrayList<String>();
	private List<Long>		totalSnapsToRetain 	= new ArrayList<Long>();
	
	
	public List<String> getVolCollectionNames() {
		return volCollectionNames;
	}
	
	public void setVolCollectionNames(List<String> volCollectionNames) {
		this.volCollectionNames = volCollectionNames;
	}
	
	public List<String> getSynchronization() {
		return synchronization;
	}
	
	public void setSynchronization(List<String> synchronization) {
		this.synchronization = synchronization;
	}
	
	public List<String> getLastSnapshot() {
		return lastSnapshot;
	}
	
	public void setLastSnapshot(List<String> lastSnapshot) {
		this.lastSnapshot = lastSnapshot;
	}
	
	public List<String> getReplicationPartner() {
		return replicationPartner;
	}
	
	public void setReplicationPartner(List<String> replicationPartner) {
		this.replicationPartner = replicationPartner;
	}
	
	public List<String> getLastReplication() {
		return lastReplication;
	}
	
	public void setLastReplication(List<String> lastReplication) {
		this.lastReplication = lastReplication;
	}
	
	public List<Long> getTotalSnapsToRetain() {
		return totalSnapsToRetain;
	}
	
	public void setTotalSnapsToRetain(List<Long> totalSnapsToRetain) {
		this.totalSnapsToRetain = totalSnapsToRetain;
	}

}
