package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.ParseInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailObject;


public class GetInitiatorGroupsTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String iGroupsResponse = new GetInitiatorGroups(ipAddress, token).getDetail();
		
		System.out.println("Initiator Groups Response: " +iGroupsResponse );
		
		GetInitiatorGroupsDetailObject iGroupObj = new ParseInitiatorGroupsDetailResponse(iGroupsResponse).parse();
		
		System.out.println("Initiator Groups size: " + iGroupObj.getData().size() );
		

		for( int i=0; i < iGroupObj.getData().size(); i++ ) {
			
			System.out.println("iGroup[" +i+ "].name: " + iGroupObj.getData().get(i).getName() );
			
		}

 	}

}
