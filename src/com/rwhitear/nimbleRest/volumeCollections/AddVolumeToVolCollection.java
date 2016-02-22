package com.rwhitear.nimbleRest.volumeCollections;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.nimbleRest.volumeCollections.json.AddVolToVolCollectionDataObject;
import com.rwhitear.nimbleRest.volumeCollections.json.AddVolToVolCollectionObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class AddVolumeToVolCollection {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	private String volID;
	
	private String volCollectionID;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
	
	// Constructors.
	public AddVolumeToVolCollection(String arrayIP, String token, String volID, String volCollectionID ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.volID = volID;
		this.volCollectionID = volCollectionID;
	}
	
	public AddVolumeToVolCollection(String arrayIP, int tcpPort, String token, String volID, String volCollectionID ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.volID = volID;
		this.volCollectionID = volCollectionID;
	}

	
	public String execute() throws HttpException, IOException {
		
		AddVolToVolCollectionDataObject addVolData = new AddVolToVolCollectionDataObject();
		
		addVolData.setVolcoll_id(this.volCollectionID);
		
		AddVolToVolCollectionObject addVol = new AddVolToVolCollectionObject();
		
		addVol.setData(addVolData);
		
		Gson gson = new Gson();
		
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.ADD_VOL_TO_VOLUME_COLLECTION_URI + this.volID );
		
		try {
			request.setMethodType( HttpRequestConstants.METHOD_TYPE_PUT );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setBodyText( gson.toJson(addVol) );
		
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
