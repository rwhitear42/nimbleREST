package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.performancePolicies.GetPerformancePolicies;
import com.rwhitear.nimbleRest.performancePolicies.json.ParsePerfPolicyDetailResponse;
import com.rwhitear.nimbleRest.performancePolicies.json.PerfPoliciesDetailJsonObject;

public class NimbleRESTperfPoliciesTest {
	
	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		// Retrieve JSON reponse for detailed Performance Policy information.
		String perfPolicyJsonData = new GetPerformancePolicies(ipAddress, token).getDetail();

		System.out.println("Performance Policy Detail JSON: " + perfPolicyJsonData );
		//actionLogger.addInfo("Performance Policy Detail JSON: " + perfPolicyJsonData );
		
		PerfPoliciesDetailJsonObject perfPolicyDetail = new ParsePerfPolicyDetailResponse(perfPolicyJsonData).parse();
		
		System.out.println("size: " + perfPolicyDetail.getData().size() );
		
		System.out.println("name: " + perfPolicyDetail.getData().get(1).getName() );
	}
	
}
