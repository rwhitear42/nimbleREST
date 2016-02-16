package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.performancePolicies.GetPerformancePolicies;
import com.rwhitear.nimbleRest.performancePolicies.json.ParsePerfPolicyDetailResponse;
import com.rwhitear.nimbleRest.performancePolicies.json.PerfPoliciesDetailJsonObject;
import com.rwhitear.nimbleRest.volumes.CreateVolume;

public class CreateVolumeTest {



	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 
		String 	volumeName 		= "russVol02"; 	
		String	volumeSizeGB	= "10";
		String	description		= "Volume description";
		String	perfPolicy		= "default";
		boolean	dataEncryption	= false;
		boolean	cachePinning	= false;
		
		
		// Retrieve the performance policy ID for perfPolicy.
		String perfPolicyID = "";

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		// Retrieve JSON reponse for detailed Performance Policy information.
		String perfPolicyJsonData = new GetPerformancePolicies(ipAddress, token).getDetail();

		System.out.println("Performance Policy Detail JSON: " + perfPolicyJsonData );
		//actionLogger.addInfo("Performance Policy Detail JSON: " + perfPolicyJsonData );
		
		PerfPoliciesDetailJsonObject perfPolicyDetail = new ParsePerfPolicyDetailResponse(perfPolicyJsonData).parse();

		for( int i=0; i < perfPolicyDetail.getData().size(); i++ ) {
			
			if( perfPolicyDetail.getData().get(i).getName().equals(perfPolicy) ) {
				
				System.out.println("Found performance policy id [" + 
						perfPolicyDetail.getData().get(i).getId() + 
						"] for Performance Policy [" + perfPolicy + "].");
				
				perfPolicyID = perfPolicyDetail.getData().get(i).getId();
				
				break;
			}
		}
		
		// Go ahead and create the volume.
		CreateVolume cv = new CreateVolume(ipAddress, token);
		
		String createResp = cv.create(volumeName, description, perfPolicyID, dataEncryption, volumeSizeGB, cachePinning);
		
		System.out.println("Create Volume Response: " + createResp);
		
	}
	
}
