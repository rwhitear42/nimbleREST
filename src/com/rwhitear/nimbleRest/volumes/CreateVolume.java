package com.rwhitear.nimbleRest.volumes;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.volumes.json.CreateVolumeDataObject;
import com.rwhitear.nimbleRest.volumes.json.CreateVolumeObject;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;

/**
 * Create a volume on a Nimble array via its RESTful API. This volume creation
 * operation will include parameters such as volume name, size, description,
 * Performance policy to use, whether to use encryption and cache pinning.
 * 
 * @author rwhitear@cisco.com
 * 
 * @version 1.0
 *
 */
public class CreateVolume {

	private String arrayIP;
	
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
	
	private String token;
	
	private String		volumeName;
	private String		volumeSizeGB;
	private String		description;
	private String		perfPolicyID;
	private boolean		dataEncryption;
	private boolean		cachePinning;
	
	
	// Constructors.	
	/**
	 * Access the Nimble array whilst leaving the TCP port at default (5392).
	 * 
	 * @param arrayIP 	Nimble array IP address.
	 * 
	 * @param token		Auth token retrieved via com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 */
	public CreateVolume( String arrayIP, String token) {
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
	public CreateVolume( String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
	
	
	/**
	 * Create a new Nimble volume.
	 * 
	 * @param volumeName 		Name to be given to the new volume.
	 * 
	 * @param description		Volume description.
	 * 
	 * @param perfPolicyID		Performance policy ID. Use com.rwhitear.nimbleRest.performancePolicies.GetPerformancePolicies
	 * 							to retrieve this ID from the performance policy name if required.
	 * 
	 * @param dataEncryption	Choose whether volume should be encrypted or not.
	 * 
	 * @param volumeSizeGB		Volume size in GB. This value needs to be converted to MB before calling the Nimble REST API
	 * 							as it accepts only MB values.
	 * 
	 * @param cachePinning		Should volume be pinned in cache?
	 * 
	 * @return					Right now, just returns the HTTP response for the request. Need to write in comprehensive error
	 * 							checking.
	 * 
	 * @throws HttpException	HTTP request exception handling.
	 * 
	 * @throws IOException		HTTP request exception handling.
	 * 
	 */
	public String create(String volumeName, String description, String perfPolicyID, boolean dataEncryption,
							String volumeSizeGB, boolean cachePinning) throws HttpException, IOException {
		
		this.volumeName = volumeName;
		this.perfPolicyID = perfPolicyID;
		this.description = description;
		this.dataEncryption = dataEncryption;
		this.volumeSizeGB = volumeSizeGB;
		this.cachePinning = cachePinning;
		
	
			
		// Convert String value to and integer, multiply it by 1024 as the REST API expects the size to 
		// be listed in MB. Convert result back to a string. 
		String volumeSizeMB = Integer.toString(Integer.parseInt(volumeSizeGB) * 1024);
		
		CreateVolumeDataObject volData = new CreateVolumeDataObject();
		
		volData.setName(this.volumeName);
		
		volData.setPerfpolicy_id(perfPolicyID);
		
		volData.setDescription(this.description);
		
		if( this.dataEncryption == true ) {
			volData.setEncryption_cipher(NimbleRESTConstants.VOLUME_ENCRYPTION_CIPHER );
		} else {
			volData.setEncryption_cipher(NimbleRESTConstants.NO_VOLUME_ENCRYPTION );
		}
		
		volData.setSize(volumeSizeMB);
		
		volData.setCache_pinned(this.cachePinning);
		
		CreateVolumeObject volObj = new CreateVolumeObject();
		
		volObj.setData(volData);
		
		Gson gson = new Gson();
		
		String bodyText = gson.toJson(volObj);
		
		System.out.println("Presend bodyText: " +bodyText );


		// Create operation.
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_VOLUME_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		request.setBodyText( bodyText );
		
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
	public String getVolumeName() {
		return volumeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public String getVolumeSizeGB() {
		return volumeSizeGB;
	}
	public void setVolumeSizeGB(String volumeSizeGB) {
		this.volumeSizeGB = volumeSizeGB;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPerfPolicy() {
		return perfPolicyID;
	}
	public void setPerfPolicy(String perfPolicyID) {
		this.perfPolicyID = perfPolicyID;
	}
	public boolean isDataEncryption() {
		return dataEncryption;
	}
	public void setDataEncryption(boolean dataEncryption) {
		this.dataEncryption = dataEncryption;
	}
	public boolean isCachePinning() {
		return cachePinning;
	}
	public void setCachePinning(boolean cachePinning) {
		this.cachePinning = cachePinning;
	}

}
