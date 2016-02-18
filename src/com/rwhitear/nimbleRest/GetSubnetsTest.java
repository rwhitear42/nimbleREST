package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.subnets.GetSubnets;
import com.rwhitear.nimbleRest.subnets.ParseSubnetsDetailResponse;
import com.rwhitear.nimbleRest.subnets.json.GetSubnetsDetailObject;

public class GetSubnetsTest {


	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String subnetsResponse = new GetSubnets(ipAddress, token).getDetail();
		
		System.out.println("Subnets Response: " +subnetsResponse );
		
		GetSubnetsDetailObject subnetObj = new ParseSubnetsDetailResponse(subnetsResponse).parse();
		
		System.out.println("Subnets size: " + subnetObj.getData().size() );
		
		for( int i=0; i < subnetObj.getData().size(); i++ ) {
			
			System.out.println("Subnet[" +i+ "].name: " + subnetObj.getData().get(i).getName() );
			
		}
 	}


}
