package com.rwhitear.nimbleRest.performancePolicies;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

/**
 * Query a Nimble array via its RESTful API and retrieve performance policy related information.
 * 
 * @author rwhitear@cisco.com
 * 
 * @version 1.0
 *
 */
public class GetPerformancePolicies {

	private String arrayIP;
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	private String token;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
	
	// Constructors.
	/**
	 * 
	 * Request performance policy information from a specified Nimble array.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 * 
	 */
	public GetPerformancePolicies(String arrayIP, String token) {
		this.arrayIP = arrayIP;
		this.token = token;
	}

	/**
	 * 
	 * Request performance policy information from a specified Nimble array whilst overriding the 
	 * default Nimble RESTful API TCP port of 5392.
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
	public GetPerformancePolicies(String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
	
	
	/**
	 * Request detailed performance policy information from a Nimble array.
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
		
		request.setUri(NimbleRESTConstants.GET_PERF_POLICY_DETAIL_URI );
		
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
