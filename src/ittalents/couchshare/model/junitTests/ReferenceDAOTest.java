package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ittalents.couchshare.model.DAO.PostDAO;
import ittalents.couchshare.model.DAO.ReferenceDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.exception.UserException;

public class ReferenceDAOTest {

	@Test
	public void testAddReference() throws UserException {
		
		new ReferenceDAO().addReference(new Reference(true, "host", new UserDAO().getUserById(8), "fuck you", new UserDAO().getUserById(1)));
		

	}
}

