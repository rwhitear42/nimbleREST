package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class VolumeClone {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	// Constructors.
	public VolumeClone(String arrayIP, String token) {
		this.arrayIP = arrayIP;
		this.token = token;
	}
	
	public VolumeClone(String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}

	
	public String create(String cloneName, String baseSnapID) throws HttpException, IOException {
			
		volumeCloneObject vco = new volumeCloneObject( cloneName, baseSnapID );
	
		//vco.setClone("true");		
		//vco.setName("sql-2-dbclone");
		//vco.setBase_snap_id("0440a3f34caa6f09be00000000000000240000139b");
		//vco.setOnline(true);
		
		volumeCloneDataObject da = new volumeCloneDataObject();
		
		da.setData(vco);
		
		Gson gson = new Gson();
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_VOLUME_CLONE_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		request.setBodyText( gson.toJson(da) );
		
		//System.out.println("Presend bodytext: " +request.getBodyText());
		
		request.execute();
		
		return request.getHttpResponse();

	}
}

class volumeCloneDataObject {
	
	private volumeCloneObject data;

	
	public volumeCloneObject getData() {
		return data;
	}

	public void setData(volumeCloneObject data) {
		this.data = data;
	}
	
}
class volumeCloneObject {
	
	private String name = null;
	private String clone = "true";
	private String base_snap_id = null;
	private boolean online = true;
	
	public volumeCloneObject(String cloneName, String base_snap_id) {
		this.name = cloneName;
		this.base_snap_id = base_snap_id;
	}
	
	public String getClone() {
		return clone;
	}
	
	public void setClone(String clone) {
		this.clone = clone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBase_snap_id() {
		return base_snap_id;
	}
	
	public void setBase_snap_id(String base_snap_id) {
		this.base_snap_id = base_snap_id;
	}
	
	public boolean getOnline() {
		return online;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
	
}
