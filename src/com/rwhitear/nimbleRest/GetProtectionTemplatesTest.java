package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.protectionTemplates.GetProtectionTemplates;
import com.rwhitear.nimbleRest.protectionTemplates.ParseProtTemplatesDetailResponse;
import com.rwhitear.nimbleRest.protectionTemplates.json.GetProtTemplatesDetailObject;


public class GetProtectionTemplatesTest {
	
	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String protTempResponse = new GetProtectionTemplates(ipAddress, token).getDetail();
		
		System.out.println("Protection templates response: " + protTempResponse );
		
		GetProtTemplatesDetailObject protTempObj = new ParseProtTemplatesDetailResponse(protTempResponse).parse();
		
		System.out.println("FC Ports size: " + protTempObj.getData().size() );
		
		for( int i=0; i < protTempObj.getData().size(); i++ ) {
			
			System.out.println("Protection template name["+i+"]: " + protTempObj.getData().get(i).getName() );
		}

	}
}
