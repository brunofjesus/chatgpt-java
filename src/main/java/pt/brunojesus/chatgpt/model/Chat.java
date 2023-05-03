package pt.brunojesus.chatgpt.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private final List<Message> messages;
	
	public Chat() {
		super();
		this.messages = new ArrayList<>();
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
}
