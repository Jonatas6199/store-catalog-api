package VO;

public class Contact extends StandardVO{
	private String email = "";
	private String number = "";
	private String facebook = "";
	private String instagram = "";
	private String twitter = "";
	private String youtube = "";
	
	public void setEmail(String contactEmail) throws Exception {
		if (contactEmail.isBlank() || contactEmail.isEmpty()) {
			throw new Exception("contactEmail não pode ser nulo ou vazio.");
		}
		else {
			email = contactEmail;
		}
	}
	public String getEmail() {
		return email;
	}
	
	public void setNumber(String contactNumber) throws Exception {
		if (contactNumber.isBlank() || contactNumber.isEmpty()) {
			throw new Exception("contactNumber não pode ser nulo ou vazio.");
		}
		else {
			number = contactNumber;
		}
	}
	public String getNumber() {
		return number;
	}
	
	public void setFacebook(String contactFacebook) throws Exception {
		if (contactFacebook.isBlank() || contactFacebook.isEmpty()) {
			throw new Exception("contactFacebook não pode ser nulo ou vazio.");
		}
		else {
			facebook = contactFacebook;
		}
	}
	public String getFacebook() {
		return facebook;
	}
	
	public void setInstagram(String contactInstagram) throws Exception {
		if (contactInstagram.isBlank() || contactInstagram.isEmpty()) {
			throw new Exception("contactInstagram não pode ser nulo ou vazio.");
		}
		else {
			instagram = contactInstagram;
		}
	}
	public String getInstagram() {
		return instagram;
	}
	
	public void setTwitter(String contactTwitter) throws Exception {
		if (contactTwitter.isBlank() || contactTwitter.isEmpty()) {
			throw new Exception("contactTwitter não pode ser nulo ou vazio.");
		}
		else {
			twitter = contactTwitter;
		}
	}
	public String getTwitter() {
		return twitter;
	}
	
	public void setyoutube(String contactYoutube) throws Exception {
		if (contactYoutube.isBlank() || contactYoutube.isEmpty()) {
			throw new Exception("contactYoutube não pode ser nulo ou vazio.");
		}
		else {
			youtube = contactYoutube;
		}
	}
	public String getYoutube() {
		return youtube;
	}
}
