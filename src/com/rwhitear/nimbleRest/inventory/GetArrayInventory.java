package com.rwhitear.nimbleRest.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.arrays.GetArrays;
import com.rwhitear.nimbleRest.arrays.ParseArraysDetailResponse;
import com.rwhitear.nimbleRest.arrays.json.GetArraysDetailObject;
import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.inventory.data.ArrayDataObject;

public class GetArrayInventory {

	private String 				username;
	private String 				password;
	private String 				deviceIp;
	
	private List<String>	arrayNames 			= new ArrayList<String>();
	private List<String> 	modelNames 			= new ArrayList<String>();
	private List<Long> 		volUsageBytes 		= new ArrayList<Long>();
	private List<Long> 		snapUsageBytes 		= new ArrayList<Long>();
	private List<Long> 		usableCapacityBytes	= new ArrayList<Long>();
	private ArrayDataObject	ado = new ArrayDataObject();
	
	// Constructor.
	public GetArrayInventory( String username, String password, String deviceIp ) {
		this.username = username;
		this.password = password;
		this.deviceIp = deviceIp;
	}
	
	public ArrayDataObject getInventory() throws HttpException, IOException {
		
		String token = new GetSessionToken(this.deviceIp, this.username, this.password).getNewToken();
		
		// Retrieve JSON response for detailed Array information.
		String arrayJsonData = new GetArrays(this.deviceIp, token).getDetail();
		
		GetArraysDetailObject arrayDetail = new ParseArraysDetailResponse(arrayJsonData).parse();
		
		if( arrayDetail.getData().size() > 0 ) {
			
			for( int i = 0; i < arrayDetail.getData().size(); i++ ) { 
				arrayNames.add( arrayDetail.getData().get(0).getName() );
				modelNames.add( arrayDetail.getData().get(0).getModel() );
				volUsageBytes.add( arrayDetail.getData().get(0).getVol_usage_bytes() );
				snapUsageBytes.add( arrayDetail.getData().get(0).getSnap_usage_bytes() );
				usableCapacityBytes.add( arrayDetail.getData().get(0).getUsable_capacity_bytes() );
			}
			
			ado.setArrayNames(arrayNames);
			ado.setModelNames(modelNames);
			ado.setVolUsageBytes(volUsageBytes);
			ado.setSnapUsageBytes(snapUsageBytes);
			ado.setUsableCapacityBytes(usableCapacityBytes);
			
		}
		
		return ado;
		
	}
	
}
