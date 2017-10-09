package itttalents.couchshare.model.interfaces;


import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.UserException;

public interface IUserDao {
	public int registerUser(User user)  throws UserException ;
	public void changeUserFirstName (int userID,String name);
	public void changeUserLastName (int userID,String name);
	public void changeUserUserName (int userID,String name);
	public User getUserById(int userId) throws UserException  ;
	
}
