package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.nimbleRest.volumes.json.OfflineVolumeDataObject;
import com.rwhitear.nimbleRest.volumes.json.OfflineVolumeObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

/**
 * Take a Nimble array volume offline via its RESTful API.
 * 
 * @author rwhitear@cisco.com
 * 
 * @version 1.0
 *
 */
public class OfflineVolume {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	private String vol_id;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;

	
	// Constructors.
	/**
	 * 
	 * Offline a Nimble array volume.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 * 
	 * @param vol_id	Nimble REST API volume ID for volume to be taken offline.
	 * 
	 */
	public OfflineVolume(String arrayIP, String token, String vol_id ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.vol_id = vol_id;
	}
	
	/**
	 * 
	 * Offline a Nimble array volume.
	 * 
	 * @param arrayIP  	IP address of the target Nimble array.
	 * 
	 * @param tcpPort	Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 * @param token 	Authentication token retrieved earlier from the array for this session
	 * 					which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 * 
	 * @param vol_id	Nimble REST API volume ID for volume to be taken offline.
	 * 
	 */

	public OfflineVolume(String arrayIP, int tcpPort, String token, String vol_id ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.vol_id = vol_id;
	}

	
	
	/**
	 * 
	 * Execute a Nimble array volume offline operation via its RESTful API.
	 *  
	 * @return	The HTTP response received following the delete request.
	 * 
	 * @throws 	HttpException HTTP request execution exception.
	 * 
	 * @throws 	IOException HTTP request execution exception.
	 */
	public String execute() throws HttpException, IOException {
 
		// Build JSON command body text required to offline volume.
		OfflineVolumeDataObject ovdo = new OfflineVolumeDataObject();
		
		ovdo.setOnline(false);
		ovdo.setForce(true);	

		OfflineVolumeObject ovd = new OfflineVolumeObject();
		
		ovd.setData(ovdo);
		
		
		Gson gson = new Gson();
		
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.OFFLINE_VOLUME_URI + this.vol_id );
		
		try {
			request.setMethodType( HttpRequestConstants.METHOD_TYPE_PUT );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setBodyText( gson.toJson(ovd) );
		
		//System.out.println("Presend bodytext: " +request.getBodyText());
		
		request.execute();
		
		this.httpStatusCode  = request.getStatusCode();
		
		if( (this.httpStatusCode != 201) && (this.httpStatusCode != 200) ) {
			
			System.out.println("Nimble array returns HTTP status [" + request.getStatusCode() + "]. Processing error.");
			
			this.errorResponse = new ProcessErrorResponse().parse(request.getHttpResponse());
			
		}
	
		return request.getHttpResponse();
			
		
	}

	
	public String getArrayIP() {
		return arrayIP;
	}

	public void setArrayIP(String arrayIP) {
		this.arrayIP = arrayIP;
	}

	public int getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVol_id() {
		return vol_id;
	}

	public void setVol_id(String vol_id) {
		this.vol_id = vol_id;
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
