package com.rwhitear.nimbleRest.authenticate;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;
import com.rwhitear.nimbleRest.authenticate.json.LoginRequestJSON;
import com.rwhitear.nimbleRest.authenticate.json.LoginResponseJSON;
import com.rwhitear.nimbleRest.contants.NimbleRESTConstants;
import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class GetSessionToken {
	
	private String arrayIP;
	private String username;
	private String password;
	private int tcp_port = NimbleRESTConstants.NIMBLE_TCP_PORT;
	private String token;
	
	// Constructors.
	public GetSessionToken() {
		
	}
	
	public GetSessionToken(String arrayIP, String username, String password) {
		this.arrayIP = arrayIP;
		this.username = username;
		this.password = password;
	}
	
	public GetSessionToken(String arrayIP, String username, String password, int tcp_port) {
		this.arrayIP = arrayIP;
		this.username = username;
		this.password = password;
		this.tcp_port = tcp_port;
	}
	
	
	public String getNewToken() throws HttpException, IOException {
		
		UCSDHttpRequest request = new UCSDHttpRequest(this.arrayIP,"https", this.tcp_port);
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		
		request.setUri("/v1/tokens");
		
		request.setMethodType(HttpRequestConstants.METHOD_TYPE_POST);
		
		request.setBodyText( new LoginRequestJSON(this.username,this.password).convertToJSON() );
		
		request.execute();
		
		//System.out.println("Status Code: " +request.getStatusCode());
		
		//System.out.println("HTTP Response:\n\n" +request.getHttpResponse());
		
		//Gson gson = new Gson();
		
		//LoginResponseJSON lrd = gson.fromJson(request.getHttpResponse(), LoginResponseJSON.class); 
		
		//System.out.println("Session Token: " +lrd.getLoginData().getSession_token());
		
		
		String token = new LoginResponseJSON().getSessionToken(request.getHttpResponse());
				
		return token;
		
	}
	
	
	
	
	public String getArrayIP() {
		return arrayIP;
	}

	public void setArrayIP(String arrayIP) {
		this.arrayIP = arrayIP;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTcp_port() {
		return tcp_port;
	}
	
	public void setTcp_port(int tcp_port) {
		this.tcp_port = tcp_port;
	}

	public String getToken() {
		return token;
	}
	
}
