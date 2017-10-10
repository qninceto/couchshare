package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ittalents.couchshare.model.DAO.RequestDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Request;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.RequestException;
import ittalents.couchshare.model.exceptions.UserException;

public class RequestDAOTest {

	@Test
	public void testAddRequest() throws UserException, PostException, RequestException {
		User u1= new UserDAO().getUserById(1);
		User u2= new UserDAO().getUserById(2);
		Request r = new Request("test", u1, Date.valueOf("2018-11-10"), Date.valueOf("2018-11-13"), u2,1);
		new RequestDAO().addRequest(r);
	}

}
