package ittalents.couchshare.model.DAO;


import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.UserException;

public interface IUserDao {
	public int registerUser(User user)  throws UserException ;
	public void changeUserFirstName (int userID);
	public void changeUserLastName (int userID);
	public void changeUserUserName (int userID);
	
}
