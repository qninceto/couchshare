package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ittalents.couchshare.model.DAO.EventDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.DAO.UserDAO.git;
import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.EventException;
import ittalents.couchshare.model.exception.UserException;

public class UserDAOTest {

//	@Test
//	public void test() {
//		new UserDAO().UserMypersonalDetails(9, "alwalda", "alwalda", "alwalda", "female", "0222", "sofia");
//	}
	
	@Test
	public void test2() throws UserException, EventException {
//	new UserDAO().UserAbout(7, "host", "bezraboten", "ittalents", "dfkjan", "i dont know", "none", "bulgaria", "germany", "bulgarian", "germany");
//		new UserDAO().userMyHome(9, 10, false, "mess");
//		new UserDAO().AccountDetails(9);
		Date a =Date.valueOf("1987-01-25");
		User user = new UserDAO().getUserById(9);
//		new UserDAO().createEvent(9,new Event(10,"birthday party",user,a,"testjhhjhjhjgghxdtfghkjl;ghgghghhg","nqkyde tam","Burgas","Bulgaria"));
//	    new UserDAO().leaveEvent(3, 9);
//		new UserDAO().addReference(7, true, "host", user, "perfect");
//		new UserDAO().SendMessage(8, "how are you", user);
//		new UserDAO().createEvent(1, 10, "mamati i mn grozna", a, "testjhhjhjhjgghxdtfghkjl", "sistrati", "Sofia", "Bulgaria");
//	System.out.println(new UserDAO().getUserById(9));  
		new UserDAO().addFriends(1, "newemail");
	}
	

}
