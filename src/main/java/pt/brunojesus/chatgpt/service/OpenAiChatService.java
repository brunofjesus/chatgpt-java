package pt.brunojesus.chatgpt.service;

import java.io.IOException;
import java.util.List;

import pt.brunojesus.chatgpt.client.OpenAiCompletionsClient;
import pt.brunojesus.chatgpt.model.Chat;
import pt.brunojesus.chatgpt.model.Message;
import pt.brunojesus.chatgpt.model.request.OpenAiRequest;
import pt.brunojesus.chatgpt.model.request.factory.OpenAiRequestFactory;
import pt.brunojesus.chatgpt.model.response.OpenAiResponse;
import pt.brunojesus.chatgpt.model.response.OpenAiResponseChoice;

public class OpenAiChatService {
	
	private OpenAiRequestFactory openAiRequestFactory;
	private OpenAiCompletionsClient openAiCompletionsClient;
	
	
	
	public OpenAiChatService(OpenAiRequestFactory openAiRequestFactory,
			OpenAiCompletionsClient openAiCompletionsClient) {
		super();
		this.openAiRequestFactory = openAiRequestFactory;
		this.openAiCompletionsClient = openAiCompletionsClient;
	}



	public List<Message> sendMessage(Chat chat, String messageToSend) throws IOException {
		final Message message = new Message("Person", messageToSend);
		chat.addMessage(message);
		
		final OpenAiRequest request = openAiRequestFactory.createChatOpenAiRequest(chat);
		final OpenAiResponse response = openAiCompletionsClient.post(request);
		
		List<Message> messages = response.getChoices().stream()
				.map(OpenAiResponseChoice::getText)
				.map(textResponse -> new Message("AI", textResponse))
				.peek(chat::addMessage)
				.toList();
		
		return messages;
	}
}
