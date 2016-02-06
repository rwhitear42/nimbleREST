package com.rwhitear.nimbleRest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.nimbleRest.authenticate.GetSessionToken;

public class NimbleRESTMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		System.out.println("Session Token: " + new GetSessionToken("10.113.89.25", "apiuser", "C1sco123").getNewToken());
		
	}

}
