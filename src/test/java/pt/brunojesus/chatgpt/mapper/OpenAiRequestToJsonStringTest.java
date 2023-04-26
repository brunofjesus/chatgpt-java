package pt.brunojesus.chatgpt.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.model.request.OpenAiRequest;

class OpenAiRequestToJsonStringTest {

	private OpenAiRequest expectedRequest = new OpenAiRequest();
	
	class DummyMapper extends ObjectMapper {
		@Override
		public String writeValueAsString(Object value) 
				throws JsonProcessingException {
			
			if (value != expectedRequest) {
				throw new AssertionError("Unexpected value");
			}
			
			return "dummy";
		}
	}
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testMapSuccess() {
		OpenAiRequestToJsonString subject = new OpenAiRequestToJsonString(
				new DummyMapper()
		);
		
		String result = subject.map(expectedRequest);
		
		assertEquals("dummy", result);
	}

}
