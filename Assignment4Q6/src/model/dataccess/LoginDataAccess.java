package model.dataccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {

	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {
		final PreparedStatement stmt = ConnectionFactory.getInstance().getConnection().prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}

