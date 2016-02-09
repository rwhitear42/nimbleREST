package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;


public class NimbleRESTMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		String token = new GetSessionToken("10.113.89.25", "apiuser", "C1sco123").getNewToken();
		
		String volumeName = "Sales-Lab-Datastore1-Shared";
		
		System.out.println("Session Token: " + token);
		
		String volumeJsonData = new GetVolumes("10.113.89.25", token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);

		if( !volID.equals(null) ) {
			
			System.out.println("Volume ID for volume "+ volumeName +" is: " +volID);
		}
	}
	
}

