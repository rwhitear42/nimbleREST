package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.accessControlRecords.CreateAccessControlRecord;
import com.rwhitear.nimbleRest.accessControlRecords.DeleteAccessControlRecord;
import com.rwhitear.nimbleRest.accessControlRecords.GetAccessControlRecords;
import com.rwhitear.nimbleRest.accessControlRecords.json.ACRobject;
import com.rwhitear.nimbleRest.accessControlRecords.json.GetACRdetailResponse;
import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.snapshots.GetSnapshots;
import com.rwhitear.nimbleRest.snapshots.json.GetSnapshotDetailResponse;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.VolumeClone;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;


public class NimbleRESTMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		/*
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123";
		String volumeName = "sql-1-db"; 
		String baseSnapshotName = "baseline";
		String cloneName = "sql-2-dbclone";
		String initiatorGroupName = "sql-2";
		 */
		String ipAddress = "10.0.27.10";
		String username = "admin";
		String password = "Nimble1234";
		String volumeName = "russ-sql-1-db"; 
		String baseSnapshotName = "baseline";
		String cloneName = "russ-sql-2-dbclone";
		String initiatorGroupName = "rw-sql-2";
				
		
		
		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		
		// Get volume ID for 'volumeName'.
		System.out.println("Retrieving volume ID for volume ["+ volumeName + "].");
		
		String volumeJsonData = new GetVolumes(ipAddress, token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);
		
		
		// Get snapshot ID for volume snapshot 'baseSnapshotName'.
		System.out.println("Retrieving snapshot ID for snapshot ["+ baseSnapshotName + "].");
		
		String volumeSnapshotJsonData = new GetSnapshots(ipAddress, token, volID).getSnapshotSummary();
		
		String snapID = new GetSnapshotDetailResponse(volumeSnapshotJsonData).getSnapshotID(baseSnapshotName);

			
		// Create clone.
		System.out.println("Creating volume clone [" + cloneName + "] from snapshot ["+ baseSnapshotName + "].");
		
		new VolumeClone(ipAddress, token).create(cloneName, snapID);
				
		
		// Initiator Groups
		System.out.println("Retrieving Initiator Group ID for iGroup ["+ initiatorGroupName + "].");
		
		String iGroupJsonData = new GetInitiatorGroups(ipAddress, token).getInitiatorGroupSummary();
		
		System.out.println("iGroupJsonData: " + iGroupJsonData);
		
		String iGroupID = new GetInitiatorGroupsDetailResponse(iGroupJsonData).getInitiatorGroupID(initiatorGroupName);
		
		
		// Delete Access Control Records for 'cloneName'.
		String acrJsonData =  new GetAccessControlRecords(ipAddress, token, cloneName).getACRsummary();

		ACRobject acrObj = new GetACRdetailResponse(acrJsonData).getResponseObject();
		
		for( int i = 0; i < acrObj.getData().size(); i++ ) {
			System.out.println( "Deleting ACR ID " + acrObj.getData().get(i).getId() );
			
			new DeleteAccessControlRecord( ipAddress, token, acrObj.getData().get(i).getId()).deleteRecord();
		}
				
		
		// Retrieve cloned Volume ID.
		System.out.println("Retrieving volume ID for volume ["+ cloneName + "].");
		
		String cloneVolumeJsonData = new GetVolumes(ipAddress, token).getSummary();
		
		String cloneVolID = new GetVolumesSummaryResponse(cloneVolumeJsonData).getVolumeID(cloneName);

		
		// Create new ACR.
		if( !cloneVolID.equals(null) ) {
			
			System.out.println("Creating new Access Control Record for volume ["+ cloneName + "] and Initiator Group [" + initiatorGroupName + "].");
			
			System.out.println("Create ACR JSON Response:\n"  + new CreateAccessControlRecord(ipAddress, token, cloneVolID, iGroupID).create());
		}
		
	}
	
}

