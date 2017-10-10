package ittalents.couchshare.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.ReferenceException;
import ittalents.couchshare.model.exceptions.UserException;
import ittalents.couchshare.model.interfaces.IEventDAO;
import ittalents.couchshare.model.interfaces.IUserDao;
import ittalents.couchshare.model.POJO.MessageBox;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.POJO.User;

public class UserDAO extends AbstractDBConnDAO implements IUserDao {

	private static final String UPDATE_USERS_SMOKING_ALLOWED = "UPDATE users set smoking_allowed = ? WHERE id =?; ";
	private static final String UPDATE_USERS_MAX_GUESTS = "UPDATE users set max_guests = ? WHERE id =?;";
	private static final String UPDATE_USERS_HOSTING_AVAILABILITIES = "UPDATE users set hosting_availabilities_id = ? WHERE id =?;";
	private static final String UPDATE_USERS_PASSWORD = "UPDATE users set password = ? WHERE id =?;";
	private static final String UPDATE_USERS_EMAIL = "UPDATE users set email = ? WHERE id =?;";
	private static final String UPDATE_USERS_CITY = "UPDATE users set City_id = ? WHERE id =?;";
	private static final String UPDATE_USERS_PHONE = "UPDATE users SET phone = ? WHERE id =?;";
	private static final String UPDATE_USER_GENDER = "UPDATE users SET genders_id = ? WHERE id =?;";
//	private static final String UPDATE_USERS_FIRST_NAME = "UPDATE users SET first_name = ? WHERE id =?; ";
//	private static final String UPDATE_USERS_LAST_NAME = "UPDATE users SET last_name = ? WHERE id =?; ";
//	private static final String UPDATE_USERS_USER_NAME = "UPDATE users SET user_name = ? WHERE id =?; ";
//	private static final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";

	private static final String INSERT_USER_INTO_DB = "INSERT into users values(null,?,?,?,?,?,null,?,"
			+ "?,null,null,?,null,null,null,null,null,null,null,null);";


	
	////////////////////////////////////////YANA:
	// TODO add post to event--->????
	// check if request is expired--->thread!/AJAX?
	// user:send a request?
	// user:accept request?
	// user:deny request?
	// GET LIST OF ALL USERS FROM A CITY--->SORTING,add filters
	
	public boolean updateEvent(int userId, Event event) throws EventException, UserException {
		if (userId == event.getCreator().getId()) {
			new EventDAO().updateEvent(event);
			return true;
		}else {
			throw new UserException("This event doesn`t belong to this user!");
		}
	}
	
	public boolean cancelEvent(int userId, Event event) throws EventException, UserException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you sure you want to cancel the event?");
		String answer = sc.next();
		if (answer.toLowerCase().equals("yes")) {
			if (userId == event.getCreator().getId()) {
				System.out.println(new EventDAO().removeEvent(event.getId()));
			} else
				throw new UserException("This event doesn`t belong to this user!");
		}
		return false;
	}

	public void createEvent(int userId, Event event) throws EventException, UserException {
		IEventDAO eventDao = new EventDAO();
		eventDao.addEvent(event);
		this.joinEvent(event.getId(), userId);
	}

	public boolean joinEvent(int eventId, int userId) throws UserException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			// TODO if statement or syso
			statement.executeUpdate("insert into events_participants values(" + userId + "," + eventId + ");");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Couldnt join the event with id" + eventId + " succesfully", e);
		}
	}

	public boolean leaveEvent(int eventId, int userId) throws UserException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			// TODO if statement or syso
			statement.executeUpdate(
					"delete from events_participants where users_id=" + eventId + " and events_id=" + userId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Couldnt leave the event with id" + eventId + " succesfully", e);
		}
	}
	///////////////////////////////////////FIRAS:




	public enum Sections {
		ocupation, education, about_me, reason_to_surf, interests, HOME_DESCRIPTION
	}

	public enum git {
		first_name, last_name, user_name
	}

//	private enum CountryLanguege {
//		CountryVisited("users_visited_countries"), countryLived("users_lived_countries"), LanguegeLearning(
//				"users_languages_learning"), LanguegeFluent("users_languages_fluent");
//
//		private final String first;
//
//		private CountryLanguege(String first) {
//			this.first = first;
//		}
//
//		public String getFirst() {
//
//			return this.first;
//		}
//	}

	private enum stringThatToGetThereId {
		GENDER("genders", "gender"), HOSTINGAVAILABILITIES("hosting_availabilities", "status"), City("cities",
				"city_name"), LANGUEGE("languages", "language_name"), Country("countries", "country_name");
		private final String first;
		private final String second;

		private stringThatToGetThereId(String first, String second) {
			this.first = first;
			this.second = second;
		}

		public String getfirst() {
			return first;
		}

		public String getSecond() {
			return second;
		}
	}

	public int registerUser(User user) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement(INSERT_USER_INTO_DB,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setDate(6, user.getDateOfBirth());
			ps.setInt(7, this.gitIdFromString(user.getGender(), stringThatToGetThereId.GENDER));
			ps.setInt(8, this.gitIdFromString(user.getCity(), stringThatToGetThereId.City));
			// ps.setDate(9,
			// java.sql.Date.valueOf(user.getDateOfRegistration().toLocalDate()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Cannot register user", e);
		}
	}

	private int gitIdFromString(String newInfo, stringThatToGetThereId string) {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = getCon().createStatement();
			result = stmt.executeQuery("select id from " + string.getfirst() + " where " + string.getSecond()
					+ " like '" + newInfo + "';");
			result.next();
			return result.getInt("id");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;

	}

	// ACCOUNT and Setting
	// MY PERSONAL DETAILS
	public void UserMypersonalDetails(int userId, String firstName, String LastName, String UserName, String gender,
			String phone, String city) {
		this.changeUserNames(userId, firstName, git.first_name);
		this.changeUserNames(userId, LastName, git.last_name);
		this.changeUserNames(userId, UserName, git.user_name);
		this.changeUserGender(userId, gender);
		this.changeUserPhone(userId, phone);
		this.changeUserCity(userId, city);

	}

	private void changeUserNames(int userID, String name, git WhatNameDoYouWantToChange) {
		try {
			String a = WhatNameDoYouWantToChange.name();
			PreparedStatement ps = getCon().prepareStatement("UPDATE users SET " + a + " = ? WHERE id =?; ");

			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void changeUserGender(int userID, String gender) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USER_GENDER);

			ps.setInt(1, this.gitIdFromString(gender, stringThatToGetThereId.GENDER));
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// MY PERSONAL DETAILS
	// END---------------------------------------------------

	// MY CONTACT DETAILS
	public void changeUserPhone(int userID, String phone) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_PHONE);

			ps.setString(1, phone);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void changeUserCity(int userID, String city) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_CITY);

			ps.setInt(1, this.gitIdFromString(city, stringThatToGetThereId.City));
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	// MY CONTACT DETAILS
	// END------------------------------------------------------
	// ACCOUNT DETAILS

	public void AccountDetails(int userID) throws UserException {
		this.changeUserEmail(userID);
		this.changeUserPAssword(userID);

	}

	public boolean passwordValidation(int userID) throws UserException {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = getCon().createStatement();
			result = stmt.executeQuery("select password from users where id = " + userID + ";");
			result.next();
			String oldPass = result.getString("password");

			System.out.println("pls eneter the  password");
			Scanner sc = new Scanner(System.in);
			String oldPassFromUser = sc.next();
			if (oldPassFromUser.equals(oldPass)) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong password  ", e);
		}
		return false;

	}

	private void changeUserEmail(int userID) throws UserException {

		try {
			if (passwordValidation(userID)) {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_EMAIL);

				System.out.println("pls enetr the new email");
				Scanner sc = new Scanner(System.in);
				String email = sc.next();

				ps.setString(1, email);
				ps.setInt(2, userID);
				ps.executeUpdate();
			} else {
				throw new UserException("wrong password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void changeUserPAssword(int userID) throws UserException {

		try {

			if (passwordValidation(userID)) {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_PASSWORD);
				System.out.println("pls enetr the new password");
				Scanner sc = new Scanner(System.in);
				String newPass = sc.next();

				ps.setString(1, newPass);
				ps.setInt(2, userID);
				ps.executeUpdate();
			} else {
				throw new UserException("wrong old password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	// ACCOUNT DETAILS
	// END-------------------------------------------------------------
	// ACCOUNT and Setting
	// END+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// Myprofile

	// ABOUT

	public void UserAbout(int userID, String HostingAvability, String occupation, String education, String about_me,
			String resons_to_surf, String interests, String CountryLivedIn, String CountryIVisited,
			String LanguegeFluent, String LanguegeLearning) throws UserException {

		this.ChangeUserHostingAvability(userID, HostingAvability);
		this.changeUserSections(userID, Sections.ocupation, occupation);
		this.changeUserSections(userID, Sections.education, education);
		this.changeUserSections(userID, Sections.about_me, about_me);
		this.changeUserSections(userID, Sections.reason_to_surf, resons_to_surf);
		this.changeUserSections(userID, Sections.interests, interests);
		this.UserAddVistedCountries(userID, CountryIVisited);
		this.UserAddLivedCountries(userID, CountryLivedIn);
		this.UserAddLanguegeLearning(userID, LanguegeLearning);
		// this.UserAddLanguegeFloent(userID, LanguegeFluent);

	}

	public void UserAddLanguegeFloent(int userID, String languege) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_languages_fluent values(?,?);");

			ps.setInt(1, userID);
			ps.setInt(2, this.gitIdFromString(languege, stringThatToGetThereId.LANGUEGE));
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong languege name ", e);
		}

	}

	public void UserAddLanguegeLearning(int userID, String languege) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_languages_learning values(?,?);");

			ps.setInt(1, userID);
			ps.setInt(2, this.gitIdFromString(languege, stringThatToGetThereId.LANGUEGE));
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong languege name ", e);
		}

	}

	public void UserAddLivedCountries(int userID, String Country) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_lived_countries values(?,?);");

			ps.setInt(1, userID);
			ps.setInt(2, this.gitIdFromString(Country, stringThatToGetThereId.Country));
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong country name ", e);
		}

	}

	public void UserAddVistedCountries(int userID, String country) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_visited_countries values(?,?);");

			ps.setInt(1, userID);
			ps.setInt(2, this.gitIdFromString(country, stringThatToGetThereId.Country));
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong country name ", e);
		}

	}

	private void ChangeUserHostingAvability(int userID, String ha) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_HOSTING_AVAILABILITIES);

			ps.setInt(1, this.gitIdFromString(ha, stringThatToGetThereId.HOSTINGAVAILABILITIES));
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void changeUserSections(int userID, Sections WhatSectionDoYouWantToChange, String text)
			throws UserException {
		try {
			String a = WhatSectionDoYouWantToChange.name();

			PreparedStatement ps = getCon().prepareStatement("UPDATE users SET " + a + " = ? WHERE id =?; ");

			ps.setString(1, text);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("somthing went wrong", e);
		}

	}

	// ABOUT
	// END------------------------------------------------------------------

	// MYHOME
	public void userMyHome(int userID, int maxGuests, boolean smokingAllowed, String homeDescription)
			throws UserException {
		this.mpChangeUserMaxGuests(userID, maxGuests);
		this.mpChangeUserAllowedSmooking(userID, smokingAllowed);
		this.changeUserSections(userID, Sections.HOME_DESCRIPTION, homeDescription);
	}

	private void mpChangeUserMaxGuests(int userID, int maxGuests) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_MAX_GUESTS);

			ps.setInt(1, maxGuests);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("wrong max guests ", e);
		}

	}

	private void mpChangeUserAllowedSmooking(int userID, boolean smokingAllowed) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_SMOKING_ALLOWED);

			ps.setBoolean(1, smokingAllowed);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	// myProfile
	// END+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// public User getUserById (int userId) throws UserException{
	// try {
	// PreparedStatement ps = getCon().prepareStatement("select *from users
	// where id ="+ userId);
	//// ps.setInt(1, userId);
	// ResultSet result = ps.executeQuery();
	// result.next();
	// int id = result.getInt(1);
	// String userName = result.getString(2);
	// String userPassword = result.getString(3);
	// String email = result.getString(4);
	// String firstName = result.getString(5);
	// String lastName = result.getString(6);
	// Date dateOfBirth= result.getDate(8);
	// String gender =getStringbyId(result.getInt(9),
	// stringThatToGetThereId.GENDER);
	// String city
	// =getStringbyId(result.getInt(12),stringThatToGetThereId.City);
	//
	// return new User(id, userName, userPassword, email, firstName, lastName,
	// dateOfBirth, gender, city);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// throw new UserException("Can't find an author with ID : " + userId, e);
	// }
	// }
	private String getStringbyId(int id, stringThatToGetThereId type) {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = getCon().createStatement();
			result = stmt.executeQuery(
					"select " + type.getSecond() + " from " + type.getfirst() + " where id = " + id + ";");
			result.next();
			return result.getString(type.getSecond());

		} catch (Exception e) {
			new UserException("there is no such String id", e);
		}
		return "null";
	}

	public void addFriends(int myId, String email) throws UserException {

		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_friends values(?,?);");

			ps.setInt(1, myId);
			ps.setInt(2, gitUserIdByEmail(email));

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("somthing went wrong try again later", e);
		}
		try {
			PreparedStatement ps = getCon().prepareStatement("insert into users_friends values(?,?);");

			ps.setInt(2, myId);
			ps.setInt(1, gitUserIdByEmail(email));

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("somthing went wrong try again later", e);
		}

	}

	private int gitUserIdByEmail(String email) {

		ResultSet result = null;

		try {
			PreparedStatement ps = getCon().prepareStatement("select id from users where email = '" + email + "';");
			// ps.setInt(1, userId);
			result = ps.executeQuery();
			result.next();
			int a = result.getInt(1);
			return result.getInt("id");

		} catch (Exception e) {
			new UserException("there is no such email", e);
		}
		return 0;
	}

//	public void createEvent(int userId, int maxNumberParticipants, String name, Date timeOTheEvent, String description,
//			String address, String city, String country) throws EventException, UserException {
//		User creator = new UserDAO().getUserById(userId);
//		IEventDAO eventDao = new EventDAO();
//		int a = eventDao.addEvent(
//				new Event(maxNumberParticipants, name, creator, timeOTheEvent, description, address, city, country));
//		this.joinEvent(a, userId);
//	}

//	public boolean joinEvent(int eventId, int userId) throws UserException {
//		Statement statement;
//		try {
//			statement = getCon().createStatement();
//			// TODO
//			statement.executeUpdate("insert into events_participants values(" + userId + "," + eventId + ");");
//
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new UserException("Couldnt join the event with id" + eventId + " succesfully", e);
//		}
//	}

//	public boolean leaveEvent(int eventId, int userId) throws UserException {
//		Statement statement;
//		try {
//			statement = getCon().createStatement();
//			// TODO
//			statement.executeUpdate(
//					"delete from events_participants where users_id= " + userId + " and events_id= " + eventId);
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new UserException("Couldnt leave the event with id" + eventId + " succesfully", e);
//		}
//	}

	public void addReference(int userId, boolean wouldReccomend, String travilingType, User reciever, String content) throws UserException, ReferenceException, PostException
			 {
		User author = new UserDAO().getUserById(userId);
		new ReferenceDAO().addReference(new Reference(wouldReccomend, travilingType, reciever, content, author));
	}

	public void SendMessage(int userId, String content, User receiver) throws UserException, PostException {
		User author = new UserDAO().getUserById(userId);
		new MessageBoxDAO().addMessageBox(new MessageBox(content, author, receiver));
	}

	// -----------------------------------------------------------------
	public User getUserById(int userId) throws UserException {
		try {
			PreparedStatement ps = getCon().prepareStatement("select *from users where id =" + userId);
			// ps.setInt(1, userId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String userName = result.getString(2);
			String userPassword = result.getString(3);
			String email = result.getString(4);
			String firstName = result.getString(5);
			String lastName = result.getString(6);
			String phone = result.getString(7);
			Date dateOfBirth = result.getDate(8);
			String gender = getStringbyId(result.getInt(9), stringThatToGetThereId.GENDER);
			String ocupation = result.getString(10);
			String eduction = result.getString(11);
			String city = getStringbyId(result.getInt(12), stringThatToGetThereId.City);
			String aboutMe = result.getString(13);
			String resonsToSurf = result.getString(14);
			String interests = result.getString(15);
			int maxGuests = result.getInt(16);
			boolean smokingAllowed = result.getBoolean(17);
			String homeDiscreption = result.getString(18);
			String currentHostingAvailability = getStringbyId(result.getInt(19),
					stringThatToGetThereId.HOSTINGAVAILABILITIES);
			Timestamp dateOfRegistration = result.getTimestamp(20);

			User user = new User(id, userName, userPassword, email, firstName, lastName, dateOfBirth, gender, city);
			user.setPhone(phone);
			user.setOcupation(ocupation);
			user.setEduction(eduction);
			user.setAboutMe(aboutMe);
			user.setResonsToSurf(resonsToSurf);
			user.setInterests(interests);
			user.setMaxGuests(maxGuests);
			user.setSmokingAllowed(smokingAllowed);
			user.setHomeDiscreption(homeDiscreption);
			user.setCurrentHostingAvailability(currentHostingAvailability);
			user.setDateOfRegistration(dateOfRegistration);

			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Can't find an author with ID : " + userId, e);
		}
	}
	
	public List <String> gitAllCountryIVisted( int userId){
		List<String> countries = new ArrayList<String>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("Select countries_id from users_visited_countries"
					+ " where users_id ="+userId+";");
		while (resultSet.next()) {
				
			String a=new UserDAO().getStringbyId(resultSet.getInt(1), stringThatToGetThereId.Country);
				countries.add(a);
			}
			return countries;
		}
			 catch (SQLException e) {
					e.printStackTrace();	
		}
		return countries;
		}

	
	public List <User> gitAllMyFriends( int userId) throws UserException{
		List<User> Friends = new ArrayList<User>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("Select  friend_id from users_friends where user_id ="+userId+";");
		while (resultSet.next()) {
				
			User a=new UserDAO().getUserById(resultSet.getInt(1));
			Friends.add(a);
			}
			return Friends;
		}
			 catch (SQLException e) {
					e.printStackTrace();	
		}
		return Friends;
		}

	
	public List <Reference> gitAllMyReference( int userId) throws UserException, ReferenceException{
		List<Reference> referens = new ArrayList<Reference>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("select *  from reference r join post p on (p.id=r.post_id)where r.receiver="+userId+";");
		while (resultSet.next()) {
			boolean wouldReccomend = resultSet.getBoolean(1);
			String travilingType =new ReferenceDAO().getTravilingTypeById((resultSet.getInt(2)));
			

			User reciever = new UserDAO().getUserById(resultSet.getInt(4));
			String content = resultSet.getString(6);
			User author = new UserDAO().getUserById(resultSet.getInt(8));
				
			Reference a=new Reference(wouldReccomend, travilingType, reciever, content, author);
			referens.add(a);
			}
			return referens;
		}
			 catch (SQLException e) {
					e.printStackTrace();	
		}
		return referens;
		}
	
	public List <MessageBox> gitMyInbox( int userId) throws UserException, ReferenceException{
		List<MessageBox> inbox = new ArrayList<MessageBox>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("select *  from message_boxes m join post p on (p.id=m.post_id)"
					+ "where m.receiver="+userId+" or p.author="+userId+" order by id desc;");
		while (resultSet.next()) {
		
			User receiver = new UserDAO().getUserById(resultSet.getInt(1));
			String content = resultSet.getString(4);
			User author = new UserDAO().getUserById(resultSet.getInt(6));
				
			MessageBox a=new MessageBox(content, author, receiver);
			inbox.add(a);
			}
			return inbox;
		}
			 catch (SQLException e) {
					e.printStackTrace();	
		}
		return inbox;
		}


	
	


}