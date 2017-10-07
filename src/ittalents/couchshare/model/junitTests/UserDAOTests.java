package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Test;

import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.City;
import ittalents.couchshare.model.POJO.Country;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.POJO.User.Gender;

public class UserDAOTests {

	@Test
	public void test() {
		System.out.println(Gender.F.getIndex());
		UserDAO user = new UserDAO();
		Country c = new Country(2, "bg");
		City ci = new City(1, "sofia", c);
		Date d = new Date(0);
		try {
			user.addUser(new User(1000, "firastest", "firastest", "firastest", "firastest", "firastest",
					d, Gender.F, ci));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		user.changeUserFirstName(10);
	}
	

}
