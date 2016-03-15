package com.rwhitear.nimbleRest.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.inventory.data.VolumeCollectionsDataObject;
import com.rwhitear.nimbleRest.volumeCollections.GetVolumeCollections;
import com.rwhitear.nimbleRest.volumeCollections.json.ParseVolCollectionsDetailResponse;
import com.rwhitear.nimbleRest.volumeCollections.json.VolCollectionsDetailJsonObject;

public class GetVolumeCollectionsInventory {
	
	private String 				username;
	private String 				password;
	private String 				deviceIp;
	
	private List<String> 	volCollectionNames 	= new ArrayList<String>();
	private List<String> 	synchronization 	= new ArrayList<String>();
	//private List<Long> 	lastSnapshot		= new ArrayList<Long>();
	//private List<String> 	replicationPartner 	= new ArrayList<String>();
	//private List<String> 	lastReplication 	= new ArrayList<String>();
	//private List<Long>	totalSnapsToRetain 	= new ArrayList<Long>();
	
	private VolumeCollectionsDataObject vcdo = new VolumeCollectionsDataObject();
	
	
	public GetVolumeCollectionsInventory( String username, String password, String deviceIp ) {
		this.username = username;
		this.password = password;
		this.deviceIp = deviceIp;
	}

	
	public VolumeCollectionsDataObject getInventory() throws HttpException, IOException {
		
		String token = new GetSessionToken(this.deviceIp, this.username, this.password).getNewToken();
		
		// Retrieve JSON response for detailed volume collections information.
		String volCollectionJsonData = new GetVolumeCollections(this.deviceIp, token).getDetail();
		
		VolCollectionsDetailJsonObject volCollDetail = new ParseVolCollectionsDetailResponse(volCollectionJsonData).parse();

		if( volCollDetail.getData().size() > 0 ) {
			
			for( int i = 0; i < volCollDetail.getData().size(); i++ ) {
				
				volCollectionNames.add( volCollDetail.getData().get(i).getName() );
				synchronization.add( volCollDetail.getData().get(i).getApp_sync() );
				
			}
			
			vcdo.setVolCollectionNames(volCollectionNames);
			vcdo.setSynchronization(synchronization);
			
		}

		return vcdo;
		
	}
	
}
