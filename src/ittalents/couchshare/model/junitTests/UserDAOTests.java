package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
//import java.time.LocalDate;

import org.junit.Test;

import ittalents.couchshare.model.DAO.UserDAO;
//import ittalents.couchshare.model.DAO.UserDAO.Sections;
import ittalents.couchshare.model.DAO.UserDAO.git;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.UserException;

public class UserDAOTests {
//ot yana merge:
//	@Test
//<<<<<<< HEAD
//						public UserDAO testCreateUser() throws UserException {
//					//		System.out.println(Gender.F.getIndex());
//							UserDAO user = new UserDAO();
//							Country c = new Country(2, "Bulgaria");
//							City ci = new City(3, "Sofia", c);
//					//		Date d = new LocalDate().now();
//							Date d =Date.valueOf("2013-09-04");
//					
//							User newUser=new User( "amtest", "amtest", "amtest", "amtest", "amtest", d, Gender.F, ci);
//							user.registerUser(newUser);
//							return user;
//						}
//						
						@Test
//						public void changeUserInformation() throws UserException {
//							testCreateUser().changeUserFirstName(10);
	public void test() throws UserException {
		
		UserDAO user = new UserDAO();
		
//		Date d = new LocalDate().now();
		Date d =Date.valueOf("2013-09-04");


//         user.registerUser(new User("yla1", "yla1", "yla1", "yla1", "yla1", d, "female", "sofia"));
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
//user.mpChangeUserHomeDescription(1);
//		System.out.println(git.first_name.toString());
////		user.changeUserFirstName(1, "lesh");
//user.changeUserSections(1, Sections.education);
//		user.changeUserGender(1,"other");
//		user.changeUserCity(1, "plovdiv");
//		user.UserAddLanguegeFluent(1, "russian");
//		User f =user.getUserById(7);
//		System.out.println(f.getCity());
//user.addFriends(9, "yla");
		user.changeUserSections(1, Sections.about_me);

	}
}
