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
	/**
	 * 
	 * Request initiator group information from a specified Nimble array.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 * 
	 */
	public GetInitiatorGroups(String arrayIP, String token) {
		this.arrayIP = arrayIP;
		this.token = token;
	}
	
	/**
	 * 
	 * Request initiator group information from a specified Nimble array whilst overriding 
	 * the default Nimble RESTful API TCP port of 5392.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public GetInitiatorGroups(String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
	
	
	/**
	 * Request detailed initiator group information from a Nimble array.
	 * 
	 * @return	The HTTP response received following the request.
	 * 
	 * @throws 	HttpException HTTP request execution exception.
	 * 
	 * @throws 	IOException HTTP request execution exception.
	 */
	public String getDetail() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON );
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri(NimbleRESTConstants.GET_INITIATOR_GROUPS_URI );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_GET );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}
	
}
