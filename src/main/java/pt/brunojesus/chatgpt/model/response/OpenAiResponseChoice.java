package pt.brunojesus.chatgpt.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiResponseChoice {
	
	private String text;
	private int index;
	private Object logprobs;
	
	@JsonProperty("finish_reason")
	private String finishReason;

	public String getText() {
		return text;
	}

	public int getIndex() {
		return index;
	}

	public Object getLogprobs() {
		return logprobs;
	}

	public String getFinishReason() {
		return finishReason;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setLogprobs(Object logprobs) {
		this.logprobs = logprobs;
	}

	public void setFinishReason(String finishReason) {
		this.finishReason = finishReason;
	}
}
