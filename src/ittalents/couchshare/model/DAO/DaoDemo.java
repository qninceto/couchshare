package ittalents.couchshare.model.DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ittalents.couchshare.model.POJO.MessageBox;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.ReferenceException;
import ittalents.couchshare.model.exception.UserException;

public class DaoDemo  {
	private List<String> country = null;
	
	public List countryList(int userId) {
		
		country = 	new UserDAO().gitAllCountryIVisted(userId);
		return country;
	}
	
	public List FriendList(int userId) throws UserException{
		List<User> friends =new UserDAO().gitAllMyFriends(userId) ;
		return friends;
	}
	
	
	public List referenceList(int userId) throws UserException, ReferenceException{
		List<Reference> reference =new UserDAO().gitAllMyReference(userId) ;
		return reference;
	}
	
	
	
	public List inboxList(int userId) throws UserException, ReferenceException{
		List<MessageBox> inbox =new UserDAO().gitMyInbox(userId) ;
		return inbox;
	}
	


}

