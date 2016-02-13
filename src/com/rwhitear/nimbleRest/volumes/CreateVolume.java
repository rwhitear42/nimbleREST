package com.rwhitear.nimbleRest.volumes;

import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;

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
	private String		perfPolicy;
	private boolean		dataEncryption;
	private boolean		cachePinning;
	
	
	// Constructors.
	public CreateVolume() {
		
	}
	
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
	
	
	// Methods here.
	
	
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
		return perfPolicy;
	}
	public void setPerfPolicy(String perfPolicy) {
		this.perfPolicy = perfPolicy;
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
