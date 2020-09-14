package mypack;

public class LoginBean {
	public boolean validate(String username, String password) {
		
		if(username.equalsIgnoreCase("Admin"))
		{
			if(password.equals("PASSWORD"))
				return true;
		}
		
		return false;
		
	}
}
