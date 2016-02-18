package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.exceptions.VolumeIdException;
import com.rwhitear.nimbleRest.exceptions.volumeCollectionException;
import com.rwhitear.nimbleRest.volumeCollections.AddVolumeToVolCollection;
import com.rwhitear.nimbleRest.volumeCollections.GetVolumeCollections;
import com.rwhitear.nimbleRest.volumeCollections.json.ParseVolCollectionsDetailResponse;
import com.rwhitear.nimbleRest.volumeCollections.json.VolCollectionsDetailJsonObject;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.json.ParseVolumeDetailResponse;
import com.rwhitear.nimbleRest.volumes.json.VolumesDetailJsonObject;

public class AddVolumeToVolCollectionTest {

	public static void main(String[] args) throws HttpException, IOException, volumeCollectionException, VolumeIdException {
		
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 
		String volumeName = "russVol02";
		String volCollName = "testVolColl";

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();

		
		// Check that the volume exists and retrieve its id.
		
		// Retrieve JSON reponse for detailed Volume information.
		String volumesJsonData = new GetVolumes(ipAddress, token).getDetail();

		System.out.println("Volumes Detail JSON: " + volumesJsonData );
		//actionLogger.addInfo("Volume Collections Detail JSON: " + volCollectinoJsonData );
		
		VolumesDetailJsonObject volumeDetail = new ParseVolumeDetailResponse(volumesJsonData).parse();
		
		System.out.println("size: " + volumeDetail.getData().size() );
		
		String volID = "";
				
		for( int i=0; i < volumeDetail.getData().size(); i++ ) {
					
			//System.out.println("Volume collection name["+i+"]: " + volCollDetail.getData().get(i).getName() );

			if( volumeDetail.getData().get(i).getName().equals(volumeName) ) {
						
				System.out.println("Found volume ["+volumeName+"] with id["+
						volumeDetail.getData().get(i).getId() +"].");
						
				volID = volumeDetail.getData().get(i).getId();
						
				break;
					
			}
					
		}
				
		// Ensure that the volume collection id for volCollName has been found.
		if( volID == "") {
					
			throw new VolumeIdException("Failed to find volume ["+volumeName+"].");
		
		}
	
		
		// Check that the volume collection exists and get its id.
		
		// Retrieve JSON response for detailed volume collections information.
		String volCollectionJsonData = new GetVolumeCollections(ipAddress, token).getDetail();

		System.out.println("Volume Collections Detail JSON: " + volCollectionJsonData );
		//actionLogger.addInfo("Volume Collections Detail JSON: " + volCollectinoJsonData );
		
		VolCollectionsDetailJsonObject volCollDetail = new ParseVolCollectionsDetailResponse(volCollectionJsonData).parse();
		
		System.out.println("size: " + volCollDetail.getData().size() );
		
		String volCollID = "";
		
		for( int i=0; i < volCollDetail.getData().size(); i++ ) {
			
			//System.out.println("Volume collection name["+i+"]: " + volCollDetail.getData().get(i).getName() );

			if( volCollDetail.getData().get(i).getName().equals(volCollName) ) {
				
				System.out.println("Found volume collection ["+volCollName+"] with id["+
						volCollDetail.getData().get(i).getId() +"].");
				
				volCollID = volCollDetail.getData().get(i).getId();
				
				break;
				
			}
			
		}
		
		// Ensure that the volume collection id for volCollName has been found.
		if( volCollID == "") {
			
			throw new volumeCollectionException("Failed to find volume collection ["+volCollName+"].");
		}
		
		// All prerequisites satisfied. Build the volume to volume collection association.
		String addVol2VolCollResponse = new AddVolumeToVolCollection(ipAddress, token, volID, volCollID).execute();
		
		System.out.println("addVol2VolCollResponse: " +addVol2VolCollResponse );
		
	}

}
