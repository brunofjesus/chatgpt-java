package pt.brunojesus.chatgpt.model.request.factory;

import pt.brunojesus.chatgpt.model.Chat;
import pt.brunojesus.chatgpt.model.request.OpenAiRequest;

public class OpenAiRequestFactory {
	
	public OpenAiRequest createChatOpenAiRequest(Chat chat) {
		final OpenAiRequest req = new OpenAiRequest();
		
		req.setModel("text-davinci-003");
		req.setPrompt(chatPromptToString(chat) + "\nAI:");
		req.setTemperature(0.5f);
		req.setMaxTokens(60);
		req.setTopP(1.0f);
		req.setFrequencyPenalty(0.5f);
		req.setPresencePenalty(0.5f);
		req.setStop(new String[] {"AI:"});
				
		return req;
	}

	private String chatPromptToString(Chat chat) {
		String result = "";
		
		// result needs to be Subject:MessageContent\n... 
		for (int i = 0; i < chat.getMessages().size(); i++) {
			result = result + "\n" + chat.getMessages().get(i).toString();
		}
		
		return result;
	}
}
