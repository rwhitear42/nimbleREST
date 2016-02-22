package com.rwhitear.nimbleRest.snapshots;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class DeleteSnapshot {
	
	
	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String snapID;
	
	private String token;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
	
	
	// Constructors.	
	/**
	 * 
	 * Delete a specified Nimble volume snapshot.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param snapID	The Nimble array snapshot ID for the snapshot that needs to be deleted.
	 * 
	 */
	public DeleteSnapshot(String arrayIP, String token, String snapID) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.snapID = snapID;
	}
	
	/**
	 * 
	 * Delete a specified Nimble volume snapshot whilst overriding the default Nimble RESTful interface 
	 * TCP port of 5392.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param snapID	The Nimble array snapshot ID for the snapshot that needs to be deleted.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public DeleteSnapshot(String arrayIP, int tcpPort, String token, String snapID) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.snapID = snapID;
	}
	

	/**
	 * Execute a Nimble array volume delete operation via its RESTful API.
	 *  
	 * @return	The HTTP response received following the delete request.
	 * 
	 * @throws 	HttpException HTTP request execution exception.
	 * 
	 * @throws 	IOException HTTP request execution exception.
	 */
	public String execute() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.DELETE_SNAPSHOT_URI +this.snapID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_DELETE );
		
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
