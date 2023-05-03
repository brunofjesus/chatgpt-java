package pt.brunojesus.chatgpt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.client.OpenAiCompletionsClient;
import pt.brunojesus.chatgpt.client.OpenAiResponseHandler;
import pt.brunojesus.chatgpt.mapper.OpenAiRequestToJsonString;
import pt.brunojesus.chatgpt.model.Chat;
import pt.brunojesus.chatgpt.model.request.*;
import pt.brunojesus.chatgpt.model.request.factory.OpenAiRequestFactory;
import pt.brunojesus.chatgpt.model.response.OpenAiResponse;
import pt.brunojesus.chatgpt.service.OpenAiChatService;
import pt.brunojesus.chatgpt.util.ConfigParser;
import pt.brunojesus.chatgpt.util.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		Map<String, String> config = ConfigParser.parse("application.properties");
		String greeting = config.get("greeting");
		String token = config.get("token");

		Chat chat = new Chat();
		OpenAiRequestFactory openAiRequestFactory = new OpenAiRequestFactory();
		OpenAiCompletionsClient openAiCompletionsClient = new OpenAiCompletionsClient(
				token,
				 new OpenAiRequestToJsonString(), 
				 new OpenAiResponseHandler(new ObjectMapper())
		);

		
		final OpenAiChatService service = new OpenAiChatService(
				openAiRequestFactory,
				openAiCompletionsClient
				);
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Person: ");
			service.sendMessage(chat, sc.nextLine()).forEach(message ->
			System.out.printf("%s: %s\n", message.getSubject(), message.getContent()));
		}
	}

}
