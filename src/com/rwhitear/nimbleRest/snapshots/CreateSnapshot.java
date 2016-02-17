package com.rwhitear.nimbleRest.snapshots;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.snapshots.json.CreateSnapshotDataObject;
import com.rwhitear.nimbleRest.snapshots.json.CreateSnapshotObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

/**
 * Create a new Nimble volume snapshot.
 * 
 * @author  rwhitear@cisco.com
 * 
 * @version	1.0
 *
 */
public class CreateSnapshot {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String snapShotName;
	
	private String volumeID;
	
	private String description;
	
	private boolean online;
	
	private boolean writable;
	
	private String token;
	
	
	// Constructors.	
	/**
	 * 
	 * Create a specified Nimble volume snapshot.
	 * 
	 * @param arrayIP  		IP address of the target Nimble array.
	 * 
	 * @param token 		Authentication token retrieved earlier from the array for this session
	 * 					  	which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  	can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  	class.
	 * 
	 * @param snapShotName	The Nimble array snapshot name that needs to be created. 
	 * 
	 * @param volumeID		The ID of the volume that requires a new snapshot.
	 * 
	 */
	public CreateSnapshot(String arrayIP, String token, String snapShotName, String volumeID, String description, 
				boolean online, boolean writable ) {
		
		this.arrayIP = arrayIP;
		this.token = token;
		this.snapShotName = snapShotName;
		this.volumeID = volumeID;
		this.description = description;
		this.online = online;
		this.writable = writable;
	}
	
	/**
	 * 
	 * Create a specified Nimble volume snapshot whilst overriding the default Nimble RESTful interface 
	 * TCP port of 5392.
	 * 
	 * @param arrayIP  		IP address of the target Nimble array.
	 * 
	 * @param token 		Authentication token retrieved earlier from the array for this session
	 * 					  	which needs to be set in an HTTP header called X-Auth-Token. Token retrieval
	 * 					  	can be achieved using the com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					  	class.
	 * 
	 * @param snapShotName	The Nimble array snapshot name that needs to be created. 
	 * 
	 * @param volumeID		The ID of the volume that requires a new snapshot.
	 * 
	 * @param tcpPort		Destination Nimble array TCP port for RESTful API access (Defaults to 5392).
	 * 
	 */
	public CreateSnapshot(String arrayIP, int tcpPort, String token, String snapShotName, String volumeID,
				String description, boolean online, boolean writable) {
		
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
		this.snapShotName = snapShotName;
		this.volumeID = volumeID;
		this.description = description;
		this.online = online;
		this.writable = writable;

	}
	

	public String execute() throws HttpException, IOException {
		
		// Create operation.
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_SNAPSHOT_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		CreateSnapshotDataObject cssdo = new CreateSnapshotDataObject();
		
		cssdo.setVol_id(this.volumeID);
		cssdo.setName(this.snapShotName);
		cssdo.setDescription(this.description);
		cssdo.setOnline(this.online);
		cssdo.setWritable(this.writable);
		
		CreateSnapshotObject cso = new CreateSnapshotObject();
		
		cso.setData(cssdo);
		
		Gson gson = new Gson();
		
		String bodyText = gson.toJson(cso);
		
		request.setBodyText( bodyText );
		
		System.out.println("Presend bodytext: " +request.getBodyText());
		
		request.execute();
		
		return request.getHttpResponse();

	}
}
