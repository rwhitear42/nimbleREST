package com.rwhitear.nimbleRest.initiatorGroups;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class DeleteInitiatorGroup {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String iGroupID;
	
	private String token;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
		

	
	
	// Constructors.	
	/**
	 * 
	 * Delete a specified Nimble initiator group.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param iGroupID	The Nimble array initiator group ID for the iGroup that needs to be deleted.
	 * 
	 */
	public DeleteInitiatorGroup(String arrayIP, String token, String iGroupID) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.iGroupID = iGroupID;
	}
	
	/**
	 * 
	 * Delete a specified Nimble initiator group whilst overriding the default Nimble RESTful interface 
	 * TCP port of 5392.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param iGroupID	The Nimble array initiator group ID for the iGroup that needs to be deleted.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public DeleteInitiatorGroup(String arrayIP, int tcpPort, String token, String iGroupID) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.iGroupID = iGroupID;
	}

	
	/**
	 * Execute a Nimble array initiator group delete operation via its RESTful API.
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
		
		request.setUri(NimbleRESTConstants.DELETE_INITIATOR_GROUP_URI +this.iGroupID );
		
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
