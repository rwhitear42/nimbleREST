package com.rwhitear.nimbleRest.constants;

public class NimbleRESTConstants {
	
	public static final int NIMBLE_TCP_PORT = 5392;
	
	
	// Nimble REST URIs
	public static final String GET_SESSION_TOKEN_URI = "/v1/tokens";
	
	public static final String GET_VOLUMES_SUMMARY_URI = "/v1/volumes";
	
	public static final String GET_VOLUMES_DETAIL_URI = "/v1/volumes/detail";
	
	public static final String GET_SNAPSHOT_DETAIL_URI = "/v1/snapshots/detail?vol_id="; // Need to add volume id to the URI in your code.
	
	public static final String GET_INITIATOR_GROUPS_URI = "/v1/initiator_groups/detail";
	
	public static final String CREATE_VOLUME_CLONE_URI = "/v1/volumes";
	
}
