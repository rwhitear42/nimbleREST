package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiators.ParseInitiatorsDetailResponse;
import com.rwhitear.nimbleRest.initiators.json.GetInitiatorsDetailObject;


public class GetInitiatorsTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String initiatorsResponse = new GetInitiatorGroups(ipAddress, token).getDetail();
		
		//System.out.println("Initiator Groups Response: " +initiatorsResponse );
		
		GetInitiatorsDetailObject initiatorsObj = new ParseInitiatorsDetailResponse(initiatorsResponse).parse();
		
		//System.out.println("Initiators size: " + initiatorsObj.getData().size() );
		

		for( int i=0; i < initiatorsObj.getData().size(); i++ ) {
			
			System.out.println("initiators[" +i+ "].name: " + initiatorsObj.getData().get(i).getName() );
			
			
			if( initiatorsObj.getData().get(i).getFc_initiators() != null ) {
				System.out.println("initiators[" +i+ "].fcinits.size: " + initiatorsObj.getData().get(i).getFc_initiators().size() );
			}
			
			if( initiatorsObj.getData().get(i).getIscsi_initiators() != null ) {
				
				System.out.println("initiators[" +i+ "].iscsi_inits.size: " + initiatorsObj.getData().get(i).getIscsi_initiators().size() );
				
				for( int j=0; j < initiatorsObj.getData().get(i).getIscsi_initiators().size(); j++ ) {
					
					System.out.println("Initiator["+j+"].label: " + initiatorsObj.getData().get(i).getIscsi_initiators().get(j).getLabel() );
					
				}
			}

		}

	}

}
