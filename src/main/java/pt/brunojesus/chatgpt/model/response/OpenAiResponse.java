package pt.brunojesus.chatgpt.model.response;

import java.util.List;

public class OpenAiResponse {
	private String id;
	private String object;
	private Long created;
	private String model;
	private List<OpenAiResponseChoice> choices;
	private OpenAiResponseUsage usage;
	
	public String getId() {
		return id;
	}
	public String getObject() {
		return object;
	}
	public Long getCreated() {
		return created;
	}
	public String getModel() {
		return model;
	}
	public List<OpenAiResponseChoice> getChoices() {
		return choices;
	}
	public OpenAiResponseUsage getUsage() {
		return usage;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setChoices(List<OpenAiResponseChoice> choices) {
		this.choices = choices;
	}
	public void setUsage(OpenAiResponseUsage usage) {
		this.usage = usage;
	}
	
	
}
