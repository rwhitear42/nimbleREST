package com.rwhitear.nimbleRest.initiators;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.exceptions.InitiatorGroupException;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.nimbleRest.initiators.json.CreateIscsiInitiatorDataObject;
import com.rwhitear.nimbleRest.initiators.json.CreateIscsiInitiatorObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class CreateIscsiInitiator {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
		
	private String token;
		
	private String		initiatorGroupID;
	private String		accessProtocol = "iscsi";
	private String		label;
	private String 		iqn;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
		
		
	// Constructors.	
	/**
	 * Access the Nimble array whilst leaving the TCP port at default (5392).
	 * 
	 * @param arrayIP 	Nimble array IP address.
	 * 
	 * @param token		Auth token retrieved via com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 */
	public CreateIscsiInitiator( String arrayIP, String token) {
		this.arrayIP = arrayIP;
		this.token = token;
	}

	/**
	 * Access the Nimble array and override the default Nimble REST API TCP port (5392).
	 * 
	 * @param arrayIP 	Nimble array IP address.
	 * 
	 * @param tcpPort	TCP port to use for REST API access.
	 * 
	 * @param token		Auth token retrieved via com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 */
	public CreateIscsiInitiator( String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
		
		
	public String create(String initiatorGroupID, String label, String iqn) throws InitiatorGroupException, HttpException, IOException {
			
		this.initiatorGroupID = initiatorGroupID;
		this.label = label;
		this.iqn = iqn;
			
		CreateIscsiInitiatorDataObject ciido = new CreateIscsiInitiatorDataObject();
		
		ciido.setAccess_protocol(this.accessProtocol);
		ciido.setInitiator_group_id(this.initiatorGroupID);
		ciido.setIqn(this.iqn);
		ciido.setLabel(this.label);

		CreateIscsiInitiatorObject ciio = new CreateIscsiInitiatorObject();
		
		ciio.setData(ciido);
		
		Gson gson = new Gson();
		
		String bodyText = gson.toJson(ciio);
			
		// Create operation.
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_INITIATOR_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		request.setBodyText( bodyText );
		
		//System.out.println("Presend bodytext: " +request.getBodyText());
		
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
