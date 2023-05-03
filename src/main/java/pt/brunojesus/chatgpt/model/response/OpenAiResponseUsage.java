package pt.brunojesus.chatgpt.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiResponseUsage {
	
	@JsonProperty("prompt_tokens")
	private int promptTokens;
	
	@JsonProperty("completion_tokens")
	private int completionTokens;
	
	@JsonProperty("total_tokens")
	private int totalTokens;

	public int getPromptTokens() {
		return promptTokens;
	}

	public int getCompletionTokens() {
		return completionTokens;
	}

	public int getTotalTokens() {
		return totalTokens;
	}

	public void setPromptTokens(int promptTokens) {
		this.promptTokens = promptTokens;
	}

	public void setCompletionTokens(int completionTokens) {
		this.completionTokens = completionTokens;
	}

	public void setTotalTokens(int totalTokens) {
		this.totalTokens = totalTokens;
	}

	
}
