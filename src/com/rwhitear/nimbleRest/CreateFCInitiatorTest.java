package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.exceptions.InitiatorGroupException;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.ParseInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailObject;
import com.rwhitear.nimbleRest.initiators.CreateFcInitiator;


public class CreateFCInitiatorTest {

	public static void main(String[] args) throws HttpException, IOException, InitiatorGroupException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 
		String initiatorGroupName = "sql-1";
		String initiatorAlias = "fcalias1";
		String wwpn = "11:22:33:44:55:66:77:88";

		
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
		CreateFcInitiator cfi = new CreateFcInitiator(ipAddress, token);
		
		String cfiCreateResponse = cfi.create(initiatorGroupID, initiatorAlias, wwpn);
		
		System.out.println("cfiCreateResponse: " + cfiCreateResponse );
		
		System.out.println("HTTP status code: " + cfi.getHttpStatusCode() );
		
		if( cfi.getHttpStatusCode() != 201 ) {
			
			ErrorResponseObject ero = cfi.getErrorResponse();
			
			for( int i = 0; i < ero.getMessages().size(); i++ ) {
				
				System.out.println("Error ["+ero.getMessages().get(i).getCode()+"]: " + ero.getMessages().get(i).getText() );
				
			}
			
			throw new InitiatorGroupException("Request failed.");
			
		}

	}

}
