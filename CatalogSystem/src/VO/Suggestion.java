package VO;

public class Suggestion extends StandardVO{
	private String suggestionDescription;
	private int userId;
	
	public void setSuggestionDescription(String description) throws Exception {
    	if (description.isBlank() || description.isEmpty()) {
    		throw new Exception("suggestionDescription não pode ser nulo ou vazio.");
    	}
    	else {
    		suggestionDescription = description;
    	}
	}
	public String getSuggestionDescription() {
		return suggestionDescription;
	}
	
	public void setUserId(int id) throws Exception {
		if (id > 0) {
			userId = id;
		}
		else {
			throw new Exception("userId deve ser maior que 0");
		}
	}
	public int getUserId() {
		return userId;
	}
}
