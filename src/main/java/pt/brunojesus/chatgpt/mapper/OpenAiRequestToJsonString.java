package pt.brunojesus.chatgpt.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.model.request.OpenAiRequest;

public class OpenAiRequestToJsonString {
	
	private final ObjectMapper mapper;
	
	public OpenAiRequestToJsonString() {
		mapper = new ObjectMapper();
	}
	
	public OpenAiRequestToJsonString(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	public String map(OpenAiRequest request) {
		String jsonPayload = null;
		try {
			jsonPayload = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
		return jsonPayload;
	}
}
