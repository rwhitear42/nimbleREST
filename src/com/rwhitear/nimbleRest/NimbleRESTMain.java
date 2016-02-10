package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

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
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123";
		String volumeName = "sql-1-db"; 
		String baseSnapshotName = "baseline";
		String cloneName = "sql-2-dbclone";
		String initiatorGroupName = "UCS3-iGroup";
		
		
		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		System.out.println("Session Token: " + token);
		
		// Get volume ID for 'volumeName'.
		String volumeJsonData = new GetVolumes(ipAddress, token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);

		if( !volID.equals(null) ) {
			
			System.out.println("Volume ID for volume "+ volumeName +" is: " +volID);
		}
		
		// Get snapshot ID for volume snapshot 'baseSnapshotName'.
		String volumeSnapshotJsonData = new GetSnapshots(ipAddress, token, volID).getSnapshotSummary();
		
		System.out.println("Snapshot ID for snapshot "+baseSnapshotName+": " +new GetSnapshotDetailResponse(volumeSnapshotJsonData).getSnapshotID(baseSnapshotName));
	
		String snapID = new GetSnapshotDetailResponse(volumeSnapshotJsonData).getSnapshotID(baseSnapshotName);
		
		// Initiator Groups
		String iGroupJsonData = new GetInitiatorGroups(ipAddress, token).getInitiatorGroupSummary();
		
		System.out.println("Initiator Group ID: " +new GetInitiatorGroupsDetailResponse(iGroupJsonData).getInitiatorGroupID(initiatorGroupName));
		 
		String response = new VolumeClone(ipAddress, token).create(cloneName, snapID);
		
		System.out.println("Create clone response: " + response);

	}
	
}

