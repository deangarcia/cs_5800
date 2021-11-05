package model.business;

import java.sql.SQLException;


import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {

	// PART ONE IMPLEMENTATION FOR THE HOMEWORK
	public static boolean Login(String userName, String password) throws ClassNotFoundException, SQLException 
	{
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		} 
		
		User user = new User(userName, password);
		
		return (!(new LoginDataAccess().verifyCredentials(user)));
	}
}
