package com.rwhitear.nimbleRest;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.inventory.GetArrayInventory;
import com.rwhitear.nimbleRest.inventory.GetInitiatorGroupsInventory;
import com.rwhitear.nimbleRest.inventory.GetPerformancePoliciesInventory;
import com.rwhitear.nimbleRest.inventory.GetVolumeCollectionsInventory;
import com.rwhitear.nimbleRest.inventory.GetVolumesInventory;
import com.rwhitear.nimbleRest.inventory.data.ArrayDataObject;
import com.rwhitear.nimbleRest.inventory.data.InitiatorGroupDataObject;
import com.rwhitear.nimbleRest.inventory.data.PerformancePolicyDataObject;
import com.rwhitear.nimbleRest.inventory.data.VolumeCollectionsDataObject;
import com.rwhitear.nimbleRest.inventory.data.VolumeDataObject;

public class GetInventoryTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String username = "apiuser";
		String password = "C1sco123";
		String deviceIp = "10.113.89.25";

		
		// Volumes information.
		
		GetVolumesInventory gvi = new GetVolumesInventory(username, password, deviceIp);
		
		VolumeDataObject vdo = gvi.getInventory();
		
		List<String> volNames = vdo.getVolNames();
		List<Long> volSizes = vdo.getVolSizes();
		List<Long> volUsageCompressedBytes = vdo.getVolUsageCompressedBytes();
		List<Long> snapUsageCompressedBytes = vdo.getSnapUsageCompressedBytes();
		List<Long> totalUsageBytes = vdo.getTotalUsageBytes();
		
		for( int i = 0; i < volNames.size(); i++ ) {
			
			System.out.println("volNames.["+i+"]: " + volNames.get(i) );
			System.out.println("volSizes.["+i+"]: " + (volSizes.get(i)/1024.0) + " GB" );
			System.out.println("volUsageCompressedBytes.["+i+"]: " + volUsageCompressedBytes.get(i) + " B" );
			System.out.println("snapUsageCompressedBytes.["+i+"]: " + snapUsageCompressedBytes.get(i) + " B" );
			System.out.println("totalUsageBytes.["+i+"]: " + totalUsageBytes.get(i) + " B" );
		
		}	
		
		// Performance policies.
		
		GetPerformancePoliciesInventory gppi = new GetPerformancePoliciesInventory(username, password, deviceIp);
		
		PerformancePolicyDataObject ppdo = gppi.getInventory();
		
		List<String> perfPolicyNames = ppdo.getPerfPolicyNames();
		
		for( int i = 0; i < perfPolicyNames.size(); i++ ) {
			
			System.out.println("perfPolicyNames["+i+"]: " + perfPolicyNames.get(i) );
			
		}
		
		
		// Initiator Groups.
		
		GetInitiatorGroupsInventory gigi = new GetInitiatorGroupsInventory(username, password, deviceIp);
		
		InitiatorGroupDataObject igdo = gigi.getInventory();
		
		List<String> initiatorGroupNames = igdo.getInitiatorGroupNames();
		
		for( int i = 0; i < initiatorGroupNames.size(); i++ ) {
			
			System.out.println("initiatorGroupNames["+i+"]: " + initiatorGroupNames.get(i) );
			
		}
		
		
		// Volume Collections.
		
		GetVolumeCollectionsInventory gvci = new GetVolumeCollectionsInventory(username, password, deviceIp);
		
		VolumeCollectionsDataObject vcdo = gvci.getInventory();
		
		List<String> 	volCollectionNames 	= vcdo.getVolCollectionNames();
		List<String> 	synchronization 	= vcdo.getSynchronization();

		for( int i = 0; i < volCollectionNames.size(); i++ ) {
			
			System.out.println("volCollectionNames["+i+"]: " + volCollectionNames.get(i) );
			System.out.println("synchronization["+i+"]: " + synchronization.get(i) );
			
		}
		
		// Array.
		
		GetArrayInventory gai = new GetArrayInventory(username, password, deviceIp);
		
		ArrayDataObject ado = gai.getInventory();
		
		List<String>	arrayNames 			= ado.getArrayNames();
		List<String> 	modelNames 			= ado.getModelNames();
		List<Long> 		volUsageBytes 		= ado.getVolUsageBytes();
		List<Long> 		snapUsageBytes 		= ado.getSnapUsageBytes();
		List<Long> 		usableCapacityBytes	= ado.getUsableCapacityBytes();
		
		for( int i = 0; i < arrayNames.size(); i++ ) {
			
			System.out.println("arrayNames["+i+"]: " + arrayNames.get(i) );
			System.out.println("modelNames["+i+"]: " + modelNames.get(i) );
			System.out.println("volUsageBytes["+i+"]: " + volUsageBytes.get(i) );
			System.out.println("snapUsageBytes["+i+"]: " + snapUsageBytes.get(i) );
			System.out.println("usableCapacityBytes["+i+"]: " + usableCapacityBytes.get(i) );
			
		}
		
	}

}
