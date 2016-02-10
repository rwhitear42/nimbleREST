package com.rwhitear.nimbleRest.accessControlRecords;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class DeleteAccessControlRecord {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String ACRid;
	
	private String token;
	
	// Constructors.
	public DeleteAccessControlRecord(String arrayIP, String token, String ACRid) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.ACRid = ACRid;
	}
	
	public DeleteAccessControlRecord(String arrayIP, int tcpPort, String token, String ACRid) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.ACRid = ACRid;
	}
	
	public String deleteRecord() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.DELETE_ACCESS_CONTROL_RECORD_URI +this.ACRid );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_DELETE );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}

}
