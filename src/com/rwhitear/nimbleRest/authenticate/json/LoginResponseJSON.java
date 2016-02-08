package com.rwhitear.nimbleRest.authenticate.json;

import com.google.gson.Gson;

public class LoginResponseJSON {
	
	private String request;
	
	
	public String getSessionToken(String request) {
		this.request = request;
		
		Gson gson = new Gson();
		
		LoginResponseJsonWrapper lrd = gson.fromJson(this.request, LoginResponseJsonWrapper.class);
		
		//System.out.println(lrd.getData().getSession_token());
		
		return lrd.getData().getSession_token();
	}
	
}

class LoginResponseJsonWrapper {
	
	private LoginResponseJSONdata data;

	public LoginResponseJSONdata getData() {
		return data;
	}

	public void setData(LoginResponseJSONdata data) {
		this.data = data;
	}
	
}



class LoginResponseJSONdata {

	private String app_name;
	private int creation_time;
	private String id;
	private int last_modified;
	private String session_token;
	private String source_ip;
	private String username;
	
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public int getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(int creation_time) {
		this.creation_time = creation_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(int last_modified) {
		this.last_modified = last_modified;
	}
	public String getSession_token() {
		return session_token;
	}
	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}
	public String getSource_ip() {
		return source_ip;
	}
	public void setSource_ip(String source_ip) {
		this.source_ip = source_ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return getApp_name() + ", " + getCreation_time() + ", " + getId() + ", " + 
				getLast_modified() + ", " + getSession_token() + ", " + getSource_ip()
				+ ", " + getUsername();
	}
}

