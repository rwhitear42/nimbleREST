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
		
		String token = new GetSessionToken("10.113.89.25", "apiuser", "C1sco123").getNewToken();
		
		String volumeName = "sql-1-db";
		
		System.out.println("Session Token: " + token);
		
		String volumeJsonData = new GetVolumes("10.113.89.25", token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);

		if( !volID.equals(null) ) {
			
			System.out.println("Volume ID for volume "+ volumeName +" is: " +volID);
		}
		
		String volumeSnapshotJsonData = new GetSnapshots("10.113.89.25", token, volID).getSnapshotSummary();
		
		System.out.println("Snapshot ID for snapshot baseline: " +new GetSnapshotDetailResponse(volumeSnapshotJsonData).getSnapshotID("baseline"));
	
		
		// Initiator Groups
		String iGroupJsonData = new GetInitiatorGroups("10.113.89.25", token).getInitiatorGroupSummary();
		
		System.out.println("Initiator Group ID: " +new GetInitiatorGroupsDetailResponse(iGroupJsonData).getInitiatorGroupID("UCS3-iGroup"));
		 
		
		new VolumeClone("10.113.89.25", token).create();
		
	}
	
}

