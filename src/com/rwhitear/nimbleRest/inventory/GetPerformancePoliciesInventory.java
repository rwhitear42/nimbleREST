package com.rwhitear.nimbleRest.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.inventory.data.PerformancePolicyDataObject;
import com.rwhitear.nimbleRest.performancePolicies.GetPerformancePolicies;
import com.rwhitear.nimbleRest.performancePolicies.json.ParsePerfPolicyDetailResponse;
import com.rwhitear.nimbleRest.performancePolicies.json.PerfPoliciesDetailJsonObject;

public class GetPerformancePoliciesInventory {

	private String 				username;
	private String 				password;
	private String 				deviceIp;
	
	private List<String> perfPolicyNames = new ArrayList<String>();
	private PerformancePolicyDataObject ppdo = new PerformancePolicyDataObject();
	
	public GetPerformancePoliciesInventory( String username, String password, String deviceIp ) {
		this.username = username;
		this.password = password;
		this.deviceIp = deviceIp;
	}

	public PerformancePolicyDataObject getInventory() throws HttpException, IOException {
		
		String token = new GetSessionToken(this.deviceIp, this.username, this.password).getNewToken();
		
		// Retrieve JSON response for detailed Performance Policy information.
		String perfPolicyJsonData = new GetPerformancePolicies(this.deviceIp, token).getDetail();

		PerfPoliciesDetailJsonObject perfPolicyDetail = new ParsePerfPolicyDetailResponse(perfPolicyJsonData).parse();

		if( perfPolicyDetail.getData().size() > 0 ) { 
			
			for( int i = 0; i < perfPolicyDetail.getData().size(); i++ ) {
				
				perfPolicyNames.add( perfPolicyDetail.getData().get(i).getName() );	
				
			}
			
			ppdo.setPerfPolicyNames(perfPolicyNames);
			
		}
		
		return ppdo;
	}
}
