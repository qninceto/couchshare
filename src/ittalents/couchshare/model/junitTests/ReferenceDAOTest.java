package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ittalents.couchshare.model.DAO.PostDAO;
import ittalents.couchshare.model.DAO.ReferenceDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
<<<<<<< HEAD
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.ReferenceException;
import ittalents.couchshare.model.exceptions.UserException;
=======
import ittalents.couchshare.model.exception.PostException;
import ittalents.couchshare.model.exception.UserException;
>>>>>>> 6e072d9f0f41adae1f7580595c36d9ffdd0ca645

public class ReferenceDAOTest {

	@Test
<<<<<<< HEAD
	public void testAddReference() throws UserException, PostException {
=======
	public void testAddReference() throws UserException, ReferenceException, PostException {
>>>>>>> 6e072d9f0f41adae1f7580595c36d9ffdd0ca645
		
		new ReferenceDAO().addReference(new Reference(true, "host", new UserDAO().getUserById(8), "fuck you", new UserDAO().getUserById(1)));
		

	}
}

