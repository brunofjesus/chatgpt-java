package pt.brunojesus.chatgpt.model.request.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pt.brunojesus.chatgpt.model.Chat;
import pt.brunojesus.chatgpt.model.Message;
import pt.brunojesus.chatgpt.model.request.OpenAiRequest;

class OpenAiRequestFactoryTest {

	private OpenAiRequestFactory subject = new OpenAiRequestFactory();

	@Test
	void testCreateChatOpenAiRequest() {
		final Chat chat = new Chat();
		chat.addMessage(new Message("AI", "HelloHuman"));

		final OpenAiRequest result = subject.createChatOpenAiRequest(chat);

		assertEquals("text-davinci-003", result.getModel());
		assertEquals(0.5f, result.getTemperature());
		assertEquals(60, result.getMaxTokens());
		assertEquals(1.0f, result.getTopP());
		assertEquals(0.5f, result.getFrequencyPenalty());
		assertEquals(0.5f, result.getPresencePenalty());

		assertNotNull(result.getStop());
		assertEquals(1, result.getStop().length);
		assertEquals("AI:", result.getStop()[0]);

		assertEquals("\nAI:HelloHuman\nAI:", result.getPrompt());
	}

}
