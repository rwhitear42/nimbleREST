package com.rwhitear.nimbleRest.httpErrorHandling.json;

import java.util.List;

public class ErrorResponseObject {
	
	private List<ErrorResponseMessagesObject> messages;

	
	public List<ErrorResponseMessagesObject> getMessages() {
		return messages;
	}

	public void setMessages(List<ErrorResponseMessagesObject> messages) {
		this.messages = messages;
	}
	
}
