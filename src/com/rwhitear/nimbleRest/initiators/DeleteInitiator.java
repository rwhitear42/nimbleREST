package com.rwhitear.nimbleRest.initiators;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class DeleteInitiator {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String initiatorID;
	
	private String token;
	
	
	// Constructors.	
	/**
	 * 
	 * Delete a specified Nimble initiator group.
	 * 
	 * @param arrayIP  		IP address of the target Nimble array.
	 * 
	 * @param token 		Authentication token retrieved earlier from the array for this session
	 * 					  	which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  	can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  	class.
	 * 
	 * @param initiatorID	The Nimble array initiator  ID for the iGroup that needs to be deleted.
	 * 
	 */
	public DeleteInitiator(String arrayIP, String token, String initiatorID ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.initiatorID = initiatorID;
	}
	
	/**
	 * 
	 * Delete a specified Nimble initiator group whilst overriding the default Nimble RESTful interface 
	 * TCP port of 5392.
	 * 
	 * @param arrayIP  		IP address of the target Nimble array.
	 * 
	 * @param token 		Authentication token retrieved earlier from the array for this session
	 * 					  	which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  	can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  	class.
	 * 
	 * @param initiatorID	The Nimble array initiator  ID for the iGroup that needs to be deleted.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public DeleteInitiator(String arrayIP, int tcpPort, String token, String initiatorID ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.initiatorID = initiatorID;
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
		
		request.setUri(NimbleRESTConstants.DELETE_INITIATOR_URI +this.initiatorID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_DELETE );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}

}
