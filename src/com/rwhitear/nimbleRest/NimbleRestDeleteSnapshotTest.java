package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.exceptions.SnapshotIdException;
import com.rwhitear.nimbleRest.exceptions.VolumeIdException;
import com.rwhitear.nimbleRest.snapshots.DeleteSnapshot;
import com.rwhitear.nimbleRest.snapshots.GetSnapshots;
import com.rwhitear.nimbleRest.snapshots.OfflineSnapshot;
import com.rwhitear.nimbleRest.snapshots.json.GetSnapshotDetailResponse;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.ParseVolumeDetailResponse;
import com.rwhitear.nimbleRest.volumes.json.VolumesDetailJsonObject;

public class NimbleRestDeleteSnapshotTest {

	public static void main(String[] args) throws HttpException, IOException, VolumeIdException, SnapshotIdException {
		
		String ipAddress 		= "10.113.89.25";
		String username 		= "apiuser";
		String password 		= "C1sco123"; 
		String 	volumeName 		= "russVol02"; 	
		String	snapShotName	= "snap03";

		// Get token.
		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		
		// Get volumeID for volumeName.
		String gvResponse = new GetVolumes(ipAddress, token).getDetail();
		
		System.out.println("GetVolumes JSON: " + gvResponse );		
		
		// Parse JSON for volumeID for volumeName.
		VolumesDetailJsonObject pvsr = new ParseVolumeDetailResponse(gvResponse).parse();
		
		String volumeID = "";
		
		for( int i=0; i<pvsr.getData().size(); i++ ) {
			
			if( pvsr.getData().get(i).getName().equals(volumeName)) {
				
				volumeID = pvsr.getData().get(i).getId();
				
				break;
				
			}
			
		}
		
		if( volumeID == "" ) {
			
			throw new VolumeIdException("Failed to find volume ID for volume [" +volumeName+ "].");
				
		} else {
			
			System.out.println("VolID for [" +volumeName+ "] is [" +volumeID+ "].");
			
		}

		// Now that we have the volumeID, we can go ahead and get the snapshot ID for snapShotName.
		String gsResponse = new GetSnapshots(ipAddress, token, volumeID).getDetail();

		System.out.println("GetSnapshots JSON: " +gsResponse );
		
		GetSnapshotDetailResponse gsdr = new GetSnapshotDetailResponse(gsResponse);
		
		String snapID = gsdr.getSnapshotID(snapShotName);
		
		if( snapID == null ) {
			
			throw new SnapshotIdException("Failed to find snapshot ID for snapshot [" +snapShotName+ "].");

		}
		
		// Snapshot ID retrieved successfully. Offline the snapshot in case it is in an online state.
		String offSnapResponse = new OfflineSnapshot(ipAddress, token, snapID).execute();
		
		System.out.println("Offline snapshot response: " +offSnapResponse );
		
		// Final step. Delete the snapshot.
		
		String delSnapResponse = new DeleteSnapshot(ipAddress, token, snapID).execute();
		
		System.out.println("Delete snapshot response: " +delSnapResponse );
		
	}

}
