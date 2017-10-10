package itttalents.couchshare.model.interfaces;

import java.sql.Date;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.EventException;
import ittalents.couchshare.model.exception.PostException;
import ittalents.couchshare.model.exception.ReferenceException;
import ittalents.couchshare.model.exception.UserException;

public interface IUserDao {
	public int registerUser(User user) throws UserException;

	public void UserMypersonalDetails(int userId, String firstName, String LastName, String UserName, String gender,
			String phone, String city);
	

	public void UserAbout(int userID, String HostingAvability, String occupation, String education, String about_me,
			String resons_to_surf, String interests, String CountryLivedIn, String CountryIVisited,
			String LanguegeFluent, String LanguegeLearning) throws UserException;

	public void userMyHome(int userID, int maxGuests, boolean smokingAllowed, String homeDescription)
			throws UserException;
	

	public void AccountDetails(int userID) throws UserException;
	

	public void addFriends(int myId, String email) throws UserException;
	//events
	public void createEvent(int userId,int maxNumberParticipants, String name ,
			Date timeOTheEvent,String description,
			String address,String city,String country) throws EventException, UserException;
	
	public boolean joinEvent(int eventId, int userId) throws UserException;
	
	
	public boolean leaveEvent(int eventId, int userId) throws UserException;
	
	
	//Reference
	
	public void addReference(int userId,boolean wouldReccomend,String travilingType,User reciever,String content) throws UserException, ReferenceException, PostException;

	//message
	public void SendMessage(int userId,String content,User receiver) throws UserException, PostException;
	public User getUserById(int userId) throws UserException;

}
