package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.snapshots.GetSnapshots;
import com.rwhitear.nimbleRest.snapshots.json.GetSnapshotDetailResponse;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;


public class NimbleRESTMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		String token = new GetSessionToken("10.113.89.25", "apiuser", "C1sco123").getNewToken();
		
		String volumeName = "russVol01";
		
		System.out.println("Session Token: " + token);
		
		String volumeJsonData = new GetVolumes("10.113.89.25", token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);

		if( !volID.equals(null) ) {
			
			System.out.println("Volume ID for volume "+ volumeName +" is: " +volID);
		}
		
		String volumeSnapshotJsonData = new GetSnapshots("10.113.89.25", token, volID).getSnapshotSummary();
		
		System.out.println("Snapshot ID: " +new GetSnapshotDetailResponse(volumeSnapshotJsonData).getSnapshotID("baseline"));
	
		//System.out.println(volumeSnapshotJsonData);
		
	}
	
}

