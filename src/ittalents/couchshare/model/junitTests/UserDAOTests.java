package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
//import java.time.LocalDate;

import org.junit.Test;

import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.City;
import ittalents.couchshare.model.POJO.Country;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.POJO.User.Gender;
import ittalents.couchshare.model.exception.UserException;

public class UserDAOTests {

	@Test
	public void test() throws UserException {
		System.out.println(Gender.F.getIndex());
		UserDAO user = new UserDAO();
		Country c = new Country( "bg");
		City ci = new City( "sofia", c);
//		Date d = new LocalDate().now();
		Date d =Date.valueOf("2013-09-04");


		user.registerUser(new User( "test", "test", "test", "test", "test", d, Gender.F, ci));
		user.changeUserFirstName(10);
	}

}
