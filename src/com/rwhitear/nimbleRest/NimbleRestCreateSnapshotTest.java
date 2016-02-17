package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.exceptions.SnapshotIdException;
import com.rwhitear.nimbleRest.exceptions.VolumeIdException;
import com.rwhitear.nimbleRest.snapshots.CreateSnapshot;
import com.rwhitear.nimbleRest.snapshots.GetSnapshots;
import com.rwhitear.nimbleRest.snapshots.json.GetSnapshotDetailResponse;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.ParseVolumeDetailResponse;
import com.rwhitear.nimbleRest.volumes.json.VolumesDetailJsonObject;

public class NimbleRestCreateSnapshotTest {

	public static void main(String[] args) throws VolumeIdException, HttpException, IOException, SnapshotIdException {
		
		String  ipAddress 		= "10.113.89.25";
		String  username 		= "apiuser";
		String  password 		= "C1sco123"; 
		String  volumeName 		= "russVol02"; 	
		String  snapShotName	= "snap04";
		String  description 	= "myDescription";
		boolean online			= true;
		boolean writable		= false;
		

		
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

		
		// Check that the snapshot doesn't already exist.
		// Now that we have the volumeID, we can go ahead and get the snapshot ID for snapShotName.
		String gsResponse = new GetSnapshots(ipAddress, token, volumeID).getDetail();

		System.out.println("GetSnapshots JSON: " +gsResponse );
		
		GetSnapshotDetailResponse gsdr = new GetSnapshotDetailResponse(gsResponse);
		
		String snapID = gsdr.getSnapshotID(snapShotName);
		
		if( snapID != null ) {
			
			throw new SnapshotIdException("The snapshot [" +snapShotName+ "] already exists." );

		}

		// Snapshot doesn't exist, go ahead and create it.
		
		CreateSnapshot cs = new CreateSnapshot(ipAddress, token, snapShotName, volumeID, description, online, writable);
		
		String csResponse = cs.execute();
		
		System.out.println("Create Snapshot Response: " + csResponse );

	}

}
