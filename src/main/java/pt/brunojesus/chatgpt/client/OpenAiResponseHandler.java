package pt.brunojesus.chatgpt.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.model.response.OpenAiResponse;

public class OpenAiResponseHandler implements HttpClientResponseHandler<OpenAiResponse> {

	private ObjectMapper objectMapper;

	public OpenAiResponseHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public OpenAiResponse handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
		OpenAiResponse result = null;

		if (response.getCode() < 200 || response.getCode() > 299) {
			return result;
		}

		InputStream body = null;

		try {
			body = response.getEntity().getContent();
			result = this.objectMapper.readValue(body, OpenAiResponse.class);
		} catch (IOException | UnsupportedOperationException e) {
			throw e;
		} finally {
			if (body != null) {
				body.close();
			}
		}

		return result;
	}

}
