package com.rwhitear.nimbleRest.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.inventory.data.VolumeDataObject;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.ParseVolumeDetailResponse;
import com.rwhitear.nimbleRest.volumes.json.VolumesDetailJsonObject;

public class GetVolumesInventory {
	
	private String 				username;
	private String 				password;
	private String 				deviceIp;
	
	private List<String> 		volNames 					= new ArrayList<String>();
	private List<Long> 			volSizes 					= new ArrayList<Long>();
	private List<Long> 			volUsageCompressedBytes 	= new ArrayList<Long>();
	private List<Long> 			snapUsageCompressedBytes	= new ArrayList<Long>();
	private List<Long> 			totalUsageBytes 			= new ArrayList<Long>();
	private VolumeDataObject	vdo 						= new VolumeDataObject();
	
	
	// Constructor.
	public GetVolumesInventory( String username, String password, String deviceIp ) {
		this.username = username;
		this.password = password;
		this.deviceIp = deviceIp;
	}
	
	public VolumeDataObject getInventory() throws HttpException, IOException {
		
		
		
		String token = new GetSessionToken(this.deviceIp, this.username, this.password).getNewToken();
		
		// Retrieve JSON response for detailed Volume information.
		String volumeJsonData = new GetVolumes(this.deviceIp, token).getDetail();
		
		VolumesDetailJsonObject volDetail = new ParseVolumeDetailResponse(volumeJsonData).parse();
		
		if( volDetail.getData().size() > 0 ) {
			
			for( int i = 0; i < volDetail.getData().size(); i++ ) {
				
				volNames.add( volDetail.getData().get(i).getName() );
				volSizes.add( volDetail.getData().get(i).getSize() );
				volUsageCompressedBytes.add( volDetail.getData().get(i).getVol_usage_compressed_bytes() );
				snapUsageCompressedBytes.add( volDetail.getData().get(i).getSnap_usage_compressed_bytes() );
				totalUsageBytes.add( volDetail.getData().get(i).getVol_usage_compressed_bytes() + 
						volDetail.getData().get(i).getSnap_usage_compressed_bytes()  );
				
			}
			
			vdo.setVolNames(volNames);
			vdo.setVolSizes(volSizes);
			vdo.setVolUsageCompressedBytes(volUsageCompressedBytes);
			vdo.setSnapUsageCompressedBytes(snapUsageCompressedBytes);
			vdo.setTotalUsageBytes(totalUsageBytes);
			
		}
		
		return vdo;
		
	}
	
	
	

}
