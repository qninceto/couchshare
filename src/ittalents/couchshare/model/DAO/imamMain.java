package ittalents.couchshare.model.DAO;

import java.sql.SQLException;

public class imamMain {
public static void main(String[] args) {
	UserDAO userDao = new UserDAO();
	
	try {
		userDao.addUser();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
