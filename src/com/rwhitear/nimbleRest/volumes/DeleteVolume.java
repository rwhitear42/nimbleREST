package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;


/**
 * Access a Nimble array and request deletion of a specified volume. Before the specified
 * volume can be deleted, validation has to be made regarding whether it has any online
 * snapshots, is associated with a volume collection and whether it is in an online state.
 * If any of these conditions exist, then the class mitigates those prior to deletion of the
 * volume.
 * 
 * @author rwhitear@cisco.com
 * 
 * @version 1.0
 *
 */
public class DeleteVolume {
	
	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String volID;
	
	private String token;
	
	
	// Constructors.	
	/**
	 * 
	 * Delete a specified Nimble volume.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param volID		The Nimble array volume ID for the volume that needs to be deleted.
	 * 
	 */
	public DeleteVolume(String arrayIP, String token, String volID) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.volID = volID;
	}
	
	/**
	 * 
	 * Delete a specified Nimble volume whilst overriding the default Nimble RESTful interface TCP port
	 * of 5392.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					  which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  class.
	 * 
	 * @param volID		The Nimble array volume ID for the volume that needs to be deleted.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public DeleteVolume(String arrayIP, int tcpPort, String token, String volID) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.volID = volID;
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
		
		request.setUri(NimbleRESTConstants.DELETE_VOLUME_URI +this.volID );
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_DELETE );
		
		request.execute();
		
		return request.getHttpResponse();
		
	}
	
}
