package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.fibreChannelPorts.GetFibreChannelPorts;
import com.rwhitear.nimbleRest.fibreChannelPorts.ParseFibreChannelPortDetailResponse;
import com.rwhitear.nimbleRest.fibreChannelPorts.json.GetFibreChannelPortsDetailObject;

public class GetFibreChannelPortsTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		String fcPortsResponse = new GetFibreChannelPorts(ipAddress, token).getDetail();
		
		System.out.println("FC Ports Response: " +fcPortsResponse );
		
		GetFibreChannelPortsDetailObject fcpObj = new ParseFibreChannelPortDetailResponse(fcPortsResponse).parse();
		
		System.out.println("FC Ports size: " + fcpObj.getData().size() );
 	}

}
