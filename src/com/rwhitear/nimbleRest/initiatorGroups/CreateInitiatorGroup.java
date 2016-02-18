package com.rwhitear.nimbleRest.initiatorGroups;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.exceptions.InitiatorGroupException;
import com.rwhitear.nimbleRest.initiatorGroups.json.CreateIgroupDataObject;
import com.rwhitear.nimbleRest.initiatorGroups.json.CreateIgroupObject;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;



/**
* Create an initiator group on a Nimble array via its RESTful API. This 
* initiator group creation operation will include parameters such as 
* initiator group name, description and access_protocol (iscsi or fc).
* 
* @author rwhitear@cisco.com
* 
* @version 1.0
*
*/
public class CreateInitiatorGroup {

	private String arrayIP;
		
	private int tcpPort = NimbleRESTConstants.NIMBLE_TCP_PORT;
		
	private String token;
		
	private String		initiatorGroupName;
	private String		description;
	private String		sanProtocol;
		
		
	// Constructors.	
	/**
	 * Access the Nimble array whilst leaving the TCP port at default (5392).
	 * 
	 * @param arrayIP 	Nimble array IP address.
	 * 
	 * @param token		Auth token retrieved via com.rwhitear.nimbleRest.authenticate.GetSessionToken
	 * 					class.
	 */
	public CreateInitiatorGroup( String arrayIP, String token) {
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
	public CreateInitiatorGroup( String arrayIP, int tcpPort, String token) {
		this.arrayIP = arrayIP;
		this.tcpPort = tcpPort;
		this.token = token;
	}
		
		
	public String create(String initiatorGroupName, String description, String sanProtocol) throws InitiatorGroupException, HttpException, IOException {
			
		this.initiatorGroupName = initiatorGroupName;
		this.description = description;
		this.sanProtocol = sanProtocol;
			
		CreateIgroupDataObject cido = new CreateIgroupDataObject();
		
		cido.setName(this.initiatorGroupName);
		
		cido.setDescription(this.description);
		
		// Check that sanProtocol equals either iscsi or fc.
		if( (!this.sanProtocol.equals("iscsi")) && (!this.sanProtocol.equals("fc")) ) {
			
			throw new InitiatorGroupException("sanProtocol = ["+this.sanProtocol+"]. Needs to be iscsi or fc.");
			
		} else {
			cido.setAccess_protocol(this.sanProtocol);
		}

		CreateIgroupObject cio = new CreateIgroupObject();
		
		cio.setData(cido);
		
		Gson gson = new Gson();
		
		String bodyText = gson.toJson(cio);
		
		
		// Create operation.
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcpPort);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.addRequestHeaders("X-Auth-Token", this.token );
		
		request.setUri( NimbleRESTConstants.CREATE_INITIATOR_GROUP_URI );
		
		request.setMethodType( HttpRequestConstants.METHOD_TYPE_POST );
		
		request.setBodyText( bodyText );
		
		//System.out.println("Presend bodytext: " +request.getBodyText());
		
		request.execute();
		
		return request.getHttpResponse();
	
	}
		

}
