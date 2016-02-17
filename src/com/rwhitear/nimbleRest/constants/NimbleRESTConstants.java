package com.rwhitear.nimbleRest.constants;

public class NimbleRESTConstants {
	
	public static final int NIMBLE_TCP_PORT = 5392;
	
	
	// Nimble REST URIs
	public static final String GET_SESSION_TOKEN_URI = "/v1/tokens";
	
	public static final String GET_VOLUMES_SUMMARY_URI = "/v1/volumes";
	
	public static final String GET_VOLUMES_DETAIL_URI = "/v1/volumes/detail";
	
	public static final String GET_INITIATOR_GROUPS_URI = "/v1/initiator_groups/detail";
	
	public static final String CREATE_VOLUME_CLONE_URI = "/v1/volumes";
	
	public static final String OFFLINE_VOLUME_URI = "/v1/volumes/"; // Volume id needs to be appended to this URI in your code.
	
	public static final String GET_ACCESS_CONTROL_RECORDS_URI = "/v1/access_control_records/detail?vol_name="; // Need to add volume name to the URI in your code.
	
	public static final String DELETE_ACCESS_CONTROL_RECORD_URI = "/v1/access_control_records/"; // Need to add ACR id to the URI in your code.

	public static final String CREATE_ACCESS_CONTROL_RECORD_URI = "/v1/access_control_records";
	
	public static final String CREATE_VOLUME_URI = "/v1/volumes";
	
	public static final String GET_VOLUME_COLLECTIONS_DETAIL_URI = "/v1/volume_collections/detail";
	
	public static final String ADD_VOL_TO_VOLUME_COLLECTION_URI = "/v1/volumes/";  // Need to add Volume ID to this URI in your code.
	
	public static final String DELETE_VOLUME_URI = "/v1/volumes/";  // Need to add Volume ID to this URI in your code.
	
	public static final String NO_VOLUME_COLLECTION_URI = ""; // Effectively adding a volume to an empty volume collection.
	
	public static final String GET_PERF_POLICY_DETAIL_URI = "/v1/performance_policies/detail";
	
	public static final String VOLUME_ENCRYPTION_CIPHER = "aes_256_xts";
	public static final String NO_VOLUME_ENCRYPTION = "none";
	
	// Snapshots.
	public static final String GET_SNAPSHOT_DETAIL_URI = "/v1/snapshots/detail?vol_id="; // Need to add volume id to the URI in your code.
	
	public static final String OFFLINE_SNAPSHOT_URI = "/v1/snapshots/"; // Need to add Snapshot ID to this URI in your code.
	
	public static final String DELETE_SNAPSHOT_URI = "/v1/snapshots/"; // Need to add Snapshot ID to this URI in your code.
	
	public static final String CREATE_SNAPSHOT_URI = "/v1/snapshots";
	
			
}
