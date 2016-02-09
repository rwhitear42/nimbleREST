package com.rwhitear.nimbleRest.initiatorGroups;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class GetInitiatorGroups {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;

	// Constructors.
	public GetInitiatorGroups(String arrayIP, String token) {
		this.arrayIP = arrayIP;
		this.token = token;
	}
	
	public GetInitiatorGroups(String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
	
	
	public String getInitiatorGroupSummary() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.GET_INITIATOR_GROUPS_URI );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_GET );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}
	
}
