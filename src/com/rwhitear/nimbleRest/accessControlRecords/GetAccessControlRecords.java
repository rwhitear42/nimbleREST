package com.rwhitear.nimbleRest.accessControlRecords;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class GetAccessControlRecords {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String volumeName;
	
	private String token;
	
	// Constructors.
	public GetAccessControlRecords(String arrayIP, String token, String volumeName) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.volumeName = volumeName;
	}
	
	public GetAccessControlRecords(String arrayIP, int tcpPort, String token, String volumeName) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.volumeName = volumeName;
	}
	
	public String getACRsummary() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.GET_ACCESS_CONTROL_RECORDS_URI +this.volumeName );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_GET );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}
	
}
