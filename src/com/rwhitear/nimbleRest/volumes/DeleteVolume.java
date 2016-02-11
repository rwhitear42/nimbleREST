package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class DeleteVolume {
	
	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String volID;
	
	private String token;
	
	// Constructors.
	public DeleteVolume(String arrayIP, String token, String volID) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.volID = volID;
	}
	
	public DeleteVolume(String arrayIP, int tcpPort, String token, String volID) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.volID = volID;
	}
	

	public String execute() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.DELETE_VOLUME_URI +this.volID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_DELETE );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}
	
}
