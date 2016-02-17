package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.volumeCollections.GetVolumeCollections;
import com.rwhitear.nimbleRest.volumeCollections.json.ParseVolCollectionsDetailResponse;
import com.rwhitear.nimbleRest.volumeCollections.json.VolCollectionsDetailJsonObject;


public class NimbleRESTvolumeCollectionsTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		// Retrieve JSON reponse for detailed Volume information.
		String volCollectinoJsonData = new GetVolumeCollections(ipAddress, token).getDetail();

		System.out.println("Volume Collections Detail JSON: " + volCollectinoJsonData );
		//actionLogger.addInfo("Volume Collections Detail JSON: " + volCollectinoJsonData );
		
		VolCollectionsDetailJsonObject volCollDetail = new ParseVolCollectionsDetailResponse(volCollectinoJsonData).parse();
		
		System.out.println("size: " + volCollDetail.getData().size() );
		
	}

}
