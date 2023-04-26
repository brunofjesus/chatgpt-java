package pt.brunojesus.chatgpt.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.model.request.OpenAiRequest;

@ExtendWith(MockitoExtension.class)
class OpenAiRequestToJsonStringTestMockito {
	
	private OpenAiRequestToJsonString subject;
	private ObjectMapper objectMapperMock;
	
	@BeforeEach
	void setUp() {
		this.objectMapperMock = Mockito.mock(ObjectMapper.class);
		this.subject = new OpenAiRequestToJsonString(objectMapperMock);
	}

	@Test
	void testSuccess() throws JsonProcessingException {
		OpenAiRequest req = Mockito.mock(OpenAiRequest.class);
		String expectedResult = "MyExpectedResult";
		
		Mockito.when(
				this.objectMapperMock.writeValueAsString(req)
				)
		.thenReturn(expectedResult);
		
		String result = this.subject.map(req);
		
		Mockito.verify(this.objectMapperMock, Mockito.times(1))
		.writeValueAsString(req);
		assertEquals(expectedResult, result);
	}
	
	@Test
	void testRuntimeException() throws JsonProcessingException {
		Exception mockedException = Mockito.mock(JsonProcessingException.class);
		
		Mockito.when(
				this.objectMapperMock.writeValueAsString(Mockito.any())
				)
		.thenThrow(mockedException);
		
		assertThrows(RuntimeException.class, () -> {
			this.subject.map(new OpenAiRequest());
		}, "Expected a Runtime Exception to be thrown when ObjectMapper throws JsonProcessingException");
	}

}
