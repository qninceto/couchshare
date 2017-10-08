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
		
		UserDAO user = new UserDAO();
		Country c = new Country( "Palestine");
		City ci = new City( 999,"gaza", c);
		
//		Date d = new LocalDate().now();
		Date d =Date.valueOf("2013-09-04");


//	user.registerUser(new User( "test12", "test12", "test12", "test12", "test12", d, Gender.F, ci).getId());
//		user.changeUserFirstName(1);
//	user.changeUserGender(1, Gender.M);
//		user.changeUserPhone(1);
//		user.changeUserCity(1, ci);
//		user.changeUserEmail(1);
//		user.changeUserPAssword(1);
//		user.mpChangeUserEduction(1);
//		user.mpChangeUserOccupation(1);
//		user.mpChangeUserAboutMe(1);
//		user.mpChangeUserResonsToSurf(1);
//		user.mpChangeUserInterests(1);
user.mpChangeUserHomeDescription(1);

	}

}
