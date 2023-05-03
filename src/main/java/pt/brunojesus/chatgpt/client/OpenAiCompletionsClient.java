package pt.brunojesus.chatgpt.client;


import java.io.IOException;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import pt.brunojesus.chatgpt.mapper.OpenAiRequestToJsonString;
import pt.brunojesus.chatgpt.model.request.OpenAiRequest;
import pt.brunojesus.chatgpt.model.response.OpenAiResponse;

public class OpenAiCompletionsClient {
	
	private final static String completionsUrl = "https://api.openai.com/v1/completions";
	
	private String token;
	private OpenAiRequestToJsonString requestToJsonMapper;
	private OpenAiResponseHandler responseHandler;
	
	public OpenAiCompletionsClient(
			String token, 
			OpenAiRequestToJsonString requestToJsonMapper,
			OpenAiResponseHandler responseHandler) {
		super();
		this.token = token;
		this.requestToJsonMapper = requestToJsonMapper;
		this.responseHandler = responseHandler;
	}
	
	public OpenAiResponse post(OpenAiRequest prompt) throws IOException {
		final String jsonPayload = requestToJsonMapper.map(prompt);
		final HttpPost httpPost = createHttpPost(jsonPayload);
		final HttpClient client = HttpClients.createDefault();
		return client.execute(httpPost, responseHandler);
	}
	
	private HttpPost createHttpPost(String payload) {
		final HttpPost httpPost = new HttpPost(completionsUrl);
		final StringEntity entity = new StringEntity(payload);
		
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("Authorization", String.format("Bearer %s", token));
		return httpPost;
	}
}
