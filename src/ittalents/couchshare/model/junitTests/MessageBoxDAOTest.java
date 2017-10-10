package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ittalents.couchshare.model.DAO.MessageBoxDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.DAO.UserDAO.git;
import ittalents.couchshare.model.POJO.MessageBox;
import ittalents.couchshare.model.exception.PostException;
import ittalents.couchshare.model.exception.UserException;

public class MessageBoxDAOTest {

	@Test
	public void test() throws UserException, PostException {
		new MessageBoxDAO().addMessageBox(new MessageBox("hello", new UserDAO().getUserById(1), new UserDAO().getUserById(9)));
	}

}
