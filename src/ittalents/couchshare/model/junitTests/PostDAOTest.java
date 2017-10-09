package ittalents.couchshare.model.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ittalents.couchshare.model.DAO.PostDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.exception.UserException;

public class PostDAOTest {

//	@Test
//	public void testAddPost() throws UserException {
//		Post p =new Post("test", new UserDAO().getUserById(7));
//		PostDAO p1 = new PostDAO();
//		p1.addPost(p);
//	}

	
	@Test
	public void testGetPostById() throws UserException {
		Post p = new PostDAO().getPostById(1);
		System.out.println(p.getAuthor());
	}

}
