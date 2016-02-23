package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.arrays.GetArrays;
import com.rwhitear.nimbleRest.arrays.ParseArraysDetailResponse;
import com.rwhitear.nimbleRest.arrays.json.GetArraysDetailObject;
import com.rwhitear.nimbleRest.authenticate.GetSessionToken;


public class GetArraysTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String getArraysResponse = new GetArrays(ipAddress, token).getDetail();
		
		System.out.println("Arrays Response: " +getArraysResponse );
		

		GetArraysDetailObject arraysObj = new ParseArraysDetailResponse(getArraysResponse).parse();
		
		System.out.println("arrays size: " + arraysObj.getData().size() );
		

		for( int i=0; i < arraysObj.getData().size(); i++ ) {
			
			System.out.println("arrays[" +i+ "].name: " + arraysObj.getData().get(i).getName() );

		}

	}

}
