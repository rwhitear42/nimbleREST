package com.rwhitear.nimbleRest.snapshots;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.snapshots.json.OfflineSnapshotDataObject;
import com.rwhitear.nimbleRest.snapshots.json.OfflineSnapshotObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class OfflineSnapshot {
	
	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	private String snapshotID;

	
	// Constructors.
	public OfflineSnapshot(String arrayIP, String token, String snapshotID ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.snapshotID = snapshotID;
	}
	
	public OfflineSnapshot(String arrayIP, int tcpPort, String token, String snapshotID ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.snapshotID = snapshotID;
	}


	public String execute() throws HttpException, IOException {

		// Create the JSON output for the bodytext.
		OfflineSnapshotDataObject offlineSnapData = new OfflineSnapshotDataObject();
		
		offlineSnapData.setId(this.snapshotID);
		offlineSnapData.setOnline(false);
		
		OfflineSnapshotObject offSnapObj = new OfflineSnapshotObject();
		
		offSnapObj.setData(offlineSnapData);
		
		Gson gson = new Gson();
		
		
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.OFFLINE_SNAPSHOT_URI + this.snapshotID );
		
		try {
			request.setMethodType( HttpRequestConstants.METHOD_TYPE_PUT );
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setBodyText( gson.toJson(offSnapObj) );
		
		request.execute();
		
		return request.getHttpResponse();

	}

}
