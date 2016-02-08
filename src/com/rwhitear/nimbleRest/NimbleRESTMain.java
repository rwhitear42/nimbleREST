package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;


public class NimbleRESTMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		String token = new GetSessionToken("10.113.89.25", "apiuser", "C1sco123").getNewToken();
		
		System.out.println("Session Token: " + token);
		
		String volumeJsonData = new GetVolumes("10.113.89.25", token).getSummary();
				
		new GetVolumesSummaryResponse(volumeJsonData).outputJSON();

	}
	
}
