package com.rwhitear.nimbleRest;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;
import com.rwhitear.nimbleRest.constants.NimbleRESTConstants;
import com.rwhitear.nimbleRest.snapshots.OfflineSnapshot;
import com.rwhitear.nimbleRest.volumeCollections.AddVolumeToVolCollection;
import com.rwhitear.nimbleRest.volumes.DeleteVolume;
import com.rwhitear.nimbleRest.volumes.GetVolumes;
import com.rwhitear.nimbleRest.volumes.OfflineVolume;
import com.rwhitear.nimbleRest.volumes.json.GetVolumesSummaryResponse;
import com.rwhitear.nimbleRest.volumes.json.ParseVolumeDetailResponse;
import com.rwhitear.nimbleRest.volumes.json.VolumesDetailJsonObject;

public class NimbleRESTdeleteVolumeTest {

	public static void main(String[] args) throws Exception {
		
		String ipAddress = "10.113.89.25";
		String username = "apiuser";
		String password = "C1sco123";
		String volumeName = "sql-1-db"; 

		// Retrieve Nimble array auth token.
		String token = new GetSessionToken(ipAddress, username, password).getNewToken();
		
		// Retrieve JSON response for detailed Volume information.
		String volumeJsonData = new GetVolumes(ipAddress, token).getDetail();
				
		VolumesDetailJsonObject volDetail = new ParseVolumeDetailResponse(volumeJsonData).parse();
		
		if( volDetail.getData().size() < 1 ) {
			
			//actionLogger.addError("Volume doesn't exist.");
			
			throw new Exception("No Volumes found.");

		}
		
		System.out.println("Attempting to delete volume [" +volumeName+ "].");
		//actionLogger.addInfo("Attempting to delete volume [" +volumeName+ "].");
	
		// Search for volumeName.
		for( int i = 0; i < volDetail.getData().size(); i++ ) {
			
			if( volDetail.getData().get(i).getName().equals(volumeName) ) {
				
				System.out.println("Found volume [" +volumeName+ "] at index[" +i+ "]." );
				
				// Check for online snapshots and offline them if any found.
				if( volDetail.getData().get(i).getOnline_snaps() != null ) {
					System.out.println("snaplen: " + volDetail.getData().get(i).getOnline_snaps().size() );
					//actionLogger.addInfo("snaplen: " + volDetail.getData().get(i).getOnline_snaps().size() );
					
					for( int j = 0; j < volDetail.getData().get(i).getOnline_snaps().size(); j++ ) {
						
						System.out.println("Taking snapshot [" + volDetail.getData().get(i).getOnline_snaps().get(j).getSnap_name() 
								+ "][" + volDetail.getData().get(i).getOnline_snaps().get(j).getSnap_id() + "] offline.");
						
						// Snapshot offline logic here.
						String offlineSnapResponse = new OfflineSnapshot(ipAddress, token, 
								volDetail.getData().get(i).getOnline_snaps().get(j).getSnap_id() ).execute();
						
						System.out.println("Snapshot ["+ volDetail.getData().get(i).getOnline_snaps().get(j).getSnap_name() 
								+"] Offline Response:\n" + offlineSnapResponse );
						//actionLogger.addInfo("Snapshot ["+ volDetail.getData().get(i).getOnline_snaps().get(j).getSnap_name() 
						//		+"] Offline Response:\n" + offlineSnapResponse );

						
					}
					
				} else {
					
					System.out.println("No online snapshots for volume [" + volumeName + "].");
					//actionLogger.addInfo("No online snapshots for volume [" + volumeName + "].");
					
				}
				
				// Check to see if the volume is online, and take offline if it is.
				if( volDetail.getData().get(i).isOnline() ) {
					System.out.println("Volume [" +volumeName+ "] is ONLINE. Taking offline...");
					//actionLogger.addInfo("Volume [" +volumeName+ "] is ONLINE.");

					// Offline the volume.
					String response = new OfflineVolume( ipAddress, token, volDetail.getData().get(i).getId() ).execute();
					
					System.out.println("Offline request response: " + response );
					
				} else {
					System.out.println("Volume [" +volumeName+ "] is offline.");
					//actionLogger.addInfo("Volume [" +volumeName+ "] is offline.");	
				}
				
				// Check to see if the volume is associated with a volume collection.
				if( !volDetail.getData().get(i).getVolcoll_name().equals("") ) {
					System.out.println("Volume [" +volumeName+ "] IS protected.");
					//actionLogger.addInfo("Volume [" ++ "] IS protected.");
					
					// Remove volume collection association logic here.
					System.out.println("Disassociating Volume Collection [" 
							+ volDetail.getData().get(i).getVolcoll_name() + "][" 
							+ volDetail.getData().get(i).getVolcoll_id() + "].");
					//actionLogger.addInfo("Disassociating Volume Collection [" 
					//		+ volDetail.getData().get(i).getVolcoll_name() + "][" 
					//		+ volDetail.getData().get(i).getVolcoll_id() + "].");
					
					String addVolCollResponse = new AddVolumeToVolCollection(ipAddress, token, 
							volDetail.getData().get(i).getId(), NimbleRESTConstants.NO_VOLUME_COLLECTION_URI ).execute();
					
					System.out.println("Add Vol to VolColl Response: \n" + addVolCollResponse );
					
				} else {
					System.out.println("Volume [" +volumeName+ "] is not protected.");
					//actionLogger.addInfo("Volume [" ++ "] is not protected.");
				}
			
				// All Dependencies have now been addressed. Go ahead and delete the volume.
				String deleteVolResponse = new DeleteVolume(ipAddress, token, volDetail.getData().get(i).getId() ).execute();
				
				System.out.println("Delete Volume Response:\n" + deleteVolResponse );
				//actionLogger.addInfo("Delete Volume Response:\n" + deleteVolResponse );
				
				// All done. Break the loop.
				break;
			}	
			
		}
		
		System.out.println("All done.");
		//actionLogger.addInfo("All done.");
		
	}
}