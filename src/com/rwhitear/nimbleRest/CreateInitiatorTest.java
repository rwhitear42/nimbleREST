package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.exceptions.InitiatorGroupException;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.ParseInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailObject;
import com.rwhitear.nimbleRest.initiators.CreateIscsiInitiator;

public class CreateInitiatorTest {

	public static void main(String[] args) throws HttpException, IOException, InitiatorGroupException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 
		String initiatorGroupName = "sql-1";
		String initiatorLabel = "initiator01";
		String iqn = "iqn.2015-07.test2";

		
		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		// Get iGroupID.
		String iGroupsResponse = new GetInitiatorGroups(ipAddress, token).getDetail();
		
		System.out.println("Initiator Groups Response: " +iGroupsResponse );
		
		GetInitiatorGroupsDetailObject iGroupObj = new ParseInitiatorGroupsDetailResponse(iGroupsResponse).parse();
		
		System.out.println("Initiator Groups size: " + iGroupObj.getData().size() );

		String initiatorGroupID = "";
		
		for( int i=0; i < iGroupObj.getData().size(); i++ ) {
			
			if( iGroupObj.getData().get(i).getName().equals(initiatorGroupName) ) {
				
				initiatorGroupID = iGroupObj.getData().get(i).getId();
				
				break;
			}
			
		}

		if( initiatorGroupID == "" ) {
			
			throw new InitiatorGroupException("Failed to find initiator group [" +initiatorGroupName+ "]." );
		}
		
		// Getting this far means an iGroup match was made. Continue.
		CreateIscsiInitiator cii = new CreateIscsiInitiator(ipAddress, token);
		
		String ciiCreateResponse = cii.create(initiatorGroupID, initiatorLabel, iqn);
		
		System.out.println("ciiCreateResponse: " + ciiCreateResponse );

	}

}
