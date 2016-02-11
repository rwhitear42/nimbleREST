package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.accessControlRecords.CreateAccessControlRecord;
import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;

public class NimbleRESTaddVoltoIgroupTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		/*
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123";
		String volumeName = "sql-1-db"; 
		String initiatorGroupName = "sql-2";
		*/
		String ipAddress = "10.0.27.10";
		String username = "admin";
		String password = "Nimble1234";
		String volumeName = "russtest"; 
		String initiatorGroupName = "rw-sql-2";

		
		
		
		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		
		// Get volume ID for 'volumeName'.
		System.out.println("Retrieving volume ID for volume ["+ volumeName + "].");
		
		String volumeJsonData = new GetVolumes(ipAddress, token).getSummary();
				
		String volID = new GetVolumesSummaryResponse(volumeJsonData).getVolumeID(volumeName);

		
		// Initiator Groups
		System.out.println("Retrieving Initiator Group ID for iGroup ["+ initiatorGroupName + "].");
		
		String iGroupJsonData = new GetInitiatorGroups(ipAddress, token).getInitiatorGroupSummary();
		
		System.out.println("iGroupJsonData: " + iGroupJsonData);
		
		String iGroupID = new GetInitiatorGroupsDetailResponse(iGroupJsonData).getInitiatorGroupID(initiatorGroupName);

		System.out.println("iGroupID: " + iGroupID );
		
		
		// Create new ACR.
		if( !volID.equals(null) ) {
			
			System.out.println("Creating new Access Control Record for volume ["+ volumeName + "] and Initiator Group [" + initiatorGroupName + "].");
			
			System.out.println("Create ACR JSON Response:\n"  + new CreateAccessControlRecord(ipAddress, token, volID, iGroupID).create());
		}

	}

}
