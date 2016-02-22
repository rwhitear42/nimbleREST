package com.rwhitear.nimbleRest.accessControlRecords;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.accessControlRecords.json.CreateACRdataObject;
import com.rwhitear.nimbleRest.accessControlRecords.json.CreateACRobject;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;


public class CreateAccessControlRecord {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;

	private String apply_to = "both";
	
	private String initiator_group_id;
	
	private String vol_id;
	
	private int					httpStatusCode;
	private ErrorResponseObject	errorResponse;
	
	// Constructors.
	public CreateAccessControlRecord(String arrayIP, String token, String vol_id, String initiator_group_id ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.vol_id = vol_id;
		this.initiator_group_id = initiator_group_id;
	}
	
	public CreateAccessControlRecord(String arrayIP, int tcpPort, String token, String vol_id, String initiator_group_id, String apply_to ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.vol_id = vol_id;
		this.initiator_group_id = initiator_group_id;
		this.apply_to = apply_to;
	}
	
	
	
	public void showJson() {
		
		CreateACRdataObject acrDataObj = new CreateACRdataObject();
		
		acrDataObj.setApply_to(apply_to);
		acrDataObj.setVol_id(vol_id);
		acrDataObj.setInitiator_group_id(initiator_group_id);
		
		CreateACRobject acrObj = new CreateACRobject();
		
		acrObj.setData(acrDataObj);

		
		System.out.println("apply_to: " + acrObj.getData().getApply_to() );
		System.out.println("vol_id: " + acrObj.getData().getVol_id() );
		System.out.println("initiator_group_id: " + acrObj.getData().getInitiator_group_id() );
		
		Gson gson = new Gson();
	
		System.out.println("Bodytext: " + gson.toJson(acrObj));
	}
	
	
	public String create() throws HttpException, IOException {
	
		CreateACRdataObject acrDataObj = new CreateACRdataObject();
		
		acrDataObj.setApply_to(apply_to);
		acrDataObj.setVol_id(vol_id);
		acrDataObj.setInitiator_group_id(initiator_group_id);
		
		CreateACRobject acrObj = new CreateACRobject();
		
		acrObj.setData(acrDataObj);
		
		Gson gson = new Gson();
		

		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_ACCESS_CONTROL_RECORD_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		request.setBodyText( gson.toJson(acrObj) );
		
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
