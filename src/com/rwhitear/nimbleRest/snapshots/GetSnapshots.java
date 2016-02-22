package com.rwhitear.nimbleRest.snapshots;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class GetSnapshots {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String volumeID;
	
	private String token;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;

	
	// Constructors.
	public GetSnapshots(String arrayIP, String token, String volumeID) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.volumeID = volumeID;
	}
	
	public GetSnapshots(String arrayIP, int tcpPort, String token, String volumeID) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.volumeID = volumeID;
	}
	
	
	public String getSnapshotSummary() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.GET_SNAPSHOT_DETAIL_URI +this.volumeID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_GET );
		
		request.execute();
		
		this.httpStatusCode  = request.getStatusCode();
		
		if( (this.httpStatusCode != 201) && (this.httpStatusCode != 200) ) {
			
			System.out.println("Nimble array returns HTTP status [" + request.getStatusCode() + "]. Processing error.");
			
			this.errorResponse = new ProcessErrorResponse().parse(request.getHttpResponse());
			
		}
		
		return request.getHttpResponse();
		
	}
	
	
	public String getDetail() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.GET_SNAPSHOT_DETAIL_URI +this.volumeID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_GET );
		
		request.execute();
		
		this.httpStatusCode  = request.getStatusCode();
		
		if( (this.httpStatusCode != 201) && (this.httpStatusCode != 200) ) {
			
			System.out.println("Nimble array returns HTTP status [" + request.getStatusCode() + "]. Processing error.");
			
			this.errorResponse = new ProcessErrorResponse().parse(request.getHttpResponse());
			
		}
		
		return request.getHttpResponse();
		
	}

	
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public ErrorResponseObject getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseObject errorResponse) {
		this.errorResponse = errorResponse;
	}

}
