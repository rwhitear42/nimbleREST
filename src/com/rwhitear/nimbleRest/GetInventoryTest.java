package com.rwhitear.nimbleRest;

import java.io.IOException;

import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.inventory.GetVolumesInventory;
import com.rwhitear.nimbleRest.inventory.data.VolumeDataObject;

public class GetInventoryTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		String username = "apiuser";
		String password = "C1sco123";
		String deviceIp = "10.113.89.25";

				
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
		
	}

}
