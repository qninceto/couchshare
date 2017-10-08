package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import ittalents.couchshare.model.POJO.City;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.POJO.User.Gender;
import ittalents.couchshare.model.POJO.User.HostingAvailability;
import ittalents.couchshare.model.exception.UserException;

public class UserDAO extends AbstractDBConnDAO implements IUserDao {

	private static final String UPDATE_USERS_HOME_DESCRIPTION = "UPDATE users set home_description = ? WHERE id =?; ";
	private static final String UPDATE_USERS_SMOKING_ALLOWED = "UPDATE users set smoking_allowed = ? WHERE id =?; ";
	private static final String UPDATE_USERS_MAX_GUESTS = "UPDATE users set max_guests = ? WHERE id =?;";
	private static final String UPDATE_USERS_INTERESTS = "UPDATE users set interests = ? WHERE id =?; ";
	private static final String UPDATE_USERS_ABOUTME = "UPDATE users set about_me = ? WHERE id =?; ";
	private static final String UPDATE_USERS_RESONS_TO_SURF = "UPDATE users set reason_to_surf = ? WHERE id =?; ";
	private static final String UPDATE_USERS_EDUCATION = "UPDATE users set education = ? WHERE id =?; ";
	private static final String UPDATE_USERS_OCUPATION = "UPDATE users set ocupation = ? WHERE id =?;";
	private static final String UPDATE_USERS_HOSTING_AVAILABILITIES = "UPDATE users set hosting_availabilities_id = ? WHERE id =?;";
	private static final String UPDATE_USERS_PASSWORD = "UPDATE users set password = ? WHERE id =?;";
	private static final String UPDATE_USERS_EMAIL = "UPDATE users set email = ? WHERE id =?;";
	private static final String UPDATE_USERS_CITY = "UPDATE users set City_id = ? WHERE id =?;";
	private static final String UPDATE_USERS_PHONE = "UPDATE users SET phone = ? WHERE id =?;";
	private static final String UPDATE_USER_GENDER = "UPDATE users SET genders_id = ? WHERE id =?;";
	private static final String UPDATE_USERS_FIRST_NAME = "UPDATE users SET first_name = ? WHERE id =?; ";
	private static final String UPDATE_USERS_LAST_NAME = "UPDATE users SET last_name = ? WHERE id =?; ";
	private static final String UPDATE_USERS_USER_NAME = "UPDATE users SET user_name = ? WHERE id =?; ";

	private static final String INSERT_USER_INTO_DB = "INSERT into users values(null,?,?,?,?,?,null,?,?"
			+ ",null,null,?,null,null,null,null,null,null,null,null);";

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
			ps.setInt(7, user.getGender().getIndex());
			ps.setInt(8, user.getCity().getId());
			// ps.setDate(9,
			// java.sql.Date.valueOf(user.getDateOfRegistration().toLocalDate()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();// lipsva while????
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("");
		}
	}
	// ACCOUNT and Setting
	// MY PERSONAL DETAILS

	public void changeUserFirstName(int userID, String name) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_FIRST_NAME);

			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void changeUserLastName(int userID, String name) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_LAST_NAME);

			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void changeUserUserName(int userID, String name) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_USER_NAME);

			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void changeUserGender(int userID, Gender gender) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USER_GENDER);

			ps.setInt(1, gender.getIndex());
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

	public void changeUserCity(int userID, City c) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_CITY);

			ps.setInt(1, c.getId());
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	// MY CONTACT DETAILS
	// END------------------------------------------------------

	// ACCOUNT DETAILS
	public boolean passwordValidation(int userID) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void changeUserEmail(int userID) throws UserException {

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

	public void changeUserPAssword(int userID) throws UserException {

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

	public void mpChangeUserHostingAvability(int userID, HostingAvailability ha) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_HOSTING_AVAILABILITIES);

			ps.setInt(1, ha.getIndex());
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void mpChangeUserOccupation(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_OCUPATION);
			System.out.println("pls enetr your occupation");
			Scanner sc = new Scanner(System.in);
			String occupation = sc.nextLine();

			ps.setString(1, occupation);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void mpChangeUserEduction(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_EDUCATION);
			System.out.println("pls enetr your eduction");
			Scanner sc = new Scanner(System.in);
			String eduction = sc.nextLine();

			ps.setString(1, eduction);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void mpChangeUserAboutMe(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_ABOUTME);
			System.out.println("pls enetr your about me section");
			Scanner sc = new Scanner(System.in);
			String amoutMe = sc.nextLine();

			ps.setString(1, amoutMe);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void mpChangeUserResonsToSurf(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_RESONS_TO_SURF);
			System.out.println("pls enetr why you are at couchshare");
			Scanner sc = new Scanner(System.in);
			String whyImhere = sc.nextLine();

			ps.setString(1, whyImhere);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void mpChangeUserInterests(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_INTERESTS);
			System.out.println("pls enetr your interests");
			Scanner sc = new Scanner(System.in);
			String interests = sc.nextLine();

			ps.setString(1, interests);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	// ABOUT
	// END------------------------------------------------------------------

	// MYHOME
	public void mpChangeUserMaxGuests(int userID, int maxGuests) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_MAX_GUESTS);

			ps.setInt(1, maxGuests);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void mpChangeUserAllowedSmooking(int userID, boolean smokingAllowed) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_SMOKING_ALLOWED);

			ps.setBoolean(1, smokingAllowed);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void mpChangeUserHomeDescription(int userID) {
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_HOME_DESCRIPTION);
			System.out.println("pls descripe your home");
			Scanner sc = new Scanner(System.in);
			String homeDescription = sc.nextLine();

			ps.setString(1, homeDescription);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}