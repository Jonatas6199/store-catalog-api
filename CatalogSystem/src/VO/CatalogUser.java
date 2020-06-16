package VO;

public class CatalogUser extends StandardVO {
	private String userEmail;
	private String userPassword;
	private String userName;
	private int isAdmin;
	
	public void setUserEmail(String email) throws Exception {
    	if (email.isBlank() || email.isEmpty()) {
    		throw new Exception("userEmail não pode ser nulo ou vazio.");
    	}
    	else {
    		userEmail = email;
    	}
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserPassword(String password) throws Exception {
    	if (password.isBlank() || password.isEmpty()) {
    		throw new Exception("userPassword não pode ser nulo ou vazio.");
    	}
    	else {
    		userPassword = password;
    	}
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserName(String name) throws Exception {
    	if (name.isBlank() || name.isEmpty()) {
    		throw new Exception("userName não pode ser nulo ou vazio.");
    	}
    	else {
    		userName = name;
    	}
	}
	public String getuserName() {
		return userName;
	}
	
	public void setIsAdmin(int isAdm) throws Exception {
		if (isAdm == 0 || isAdm == 1) {
			isAdmin = isAdm;
		}
		else {
			throw new Exception("isAdmin deve ser 0 ou 1.");
		}
	}
	public int getIsAdmin() {
		return isAdmin;
	}
}
