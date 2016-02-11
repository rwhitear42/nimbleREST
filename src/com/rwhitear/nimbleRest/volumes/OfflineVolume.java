package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.volumes.json.OfflineVolumeDataObject;
import com.rwhitear.nimbleRest.volumes.json.OfflineVolumeObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;


public class OfflineVolume {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	private String vol_id;
	
	// Constructors.
	public OfflineVolume(String arrayIP, String token, String vol_id ) {
		this.arrayIP = arrayIP;
		this.token = token;
		this.vol_id = vol_id;
	}
	
	public OfflineVolume(String arrayIP, int tcpPort, String token, String vol_id ) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.vol_id = vol_id;
	}

	
	
	
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
	
}
