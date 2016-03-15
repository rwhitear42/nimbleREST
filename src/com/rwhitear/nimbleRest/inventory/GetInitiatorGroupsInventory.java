package com.rwhitear.nimbleRest.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.initiatorGroups.GetInitiatorGroups;
import com.rwhitear.nimbleRest.initiatorGroups.ParseInitiatorGroupsDetailResponse;
import com.rwhitear.nimbleRest.initiatorGroups.json.GetInitiatorGroupsDetailObject;
import com.rwhitear.nimbleRest.inventory.data.InitiatorGroupDataObject;

public class GetInitiatorGroupsInventory {
	
	private String 				username;
	private String 				password;
	private String 				deviceIp;
	
	private List<String> initiatorGroupNames = new ArrayList<String>();
	private InitiatorGroupDataObject igdo = new InitiatorGroupDataObject();
	
	
	public GetInitiatorGroupsInventory( String username, String password, String deviceIp ) {
		this.username = username;
		this.password = password;
		this.deviceIp = deviceIp;
	}

	
	public InitiatorGroupDataObject getInventory() throws HttpException, IOException {
		
		String token = new GetSessionToken(this.deviceIp, this.username, this.password).getNewToken();
	
		String iGroupsJsonData = new GetInitiatorGroups(this.deviceIp, token).getDetail();
		
		GetInitiatorGroupsDetailObject iGroupDetail = new ParseInitiatorGroupsDetailResponse(iGroupsJsonData).parse();
		
		if( iGroupDetail.getData().size() > 0 ) {
			
			for( int i = 0; i < iGroupDetail.getData().size(); i++ ) {
				
				initiatorGroupNames.add( iGroupDetail.getData().get(i).getName() );
				
			}
			
			igdo.setInitiatorGroupNames(initiatorGroupNames);
			
		}
		
		return igdo;
		
	}

}
