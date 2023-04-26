package pt.brunojesus.chatgpt;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.mapper.OpenAiRequestToJsonString;
import pt.brunojesus.chatgpt.model.Chat;
import pt.brunojesus.chatgpt.model.request.*;
import pt.brunojesus.chatgpt.model.request.factory.OpenAiRequestFactory;
import pt.brunojesus.chatgpt.util.ConfigParser;
import pt.brunojesus.chatgpt.util.FileUtils;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Map<String, String> config = ConfigParser.parse("application.properties");
		String greeting = config.get("greeting");
		
		System.out.println(greeting);
		
		OpenAiRequestFactory openAiRequestFactory = new OpenAiRequestFactory();
		Chat chat = new Chat(greeting);
		OpenAiRequest req = openAiRequestFactory.createChatOpenAiRequest(chat);
				
		OpenAiRequestToJsonString mapper = new OpenAiRequestToJsonString();
		String jsonPayload = mapper.map(req);
		
		System.out.println(jsonPayload);
	}

}
