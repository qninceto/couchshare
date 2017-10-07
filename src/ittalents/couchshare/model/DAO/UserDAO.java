package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import ittalents.couchshare.model.POJO.User;

public class UserDAO extends AbstractDBConnDAO {

	private static final String UPDATE_USERS_FIRST_NAME = "UPDATE users SET first_name = ? WHERE id =?; ";
	private static final String UPDATE_USERS_LAST_NAME = "UPDATE users SET last_name = ? WHERE id =?; ";
	private static final String UPDATE_USERS_USER_NAME = "UPDATE users SET user_name = ? WHERE id =?; ";

	
	private static final String INSERT_USER_INTO_DB = "INSERT into users values(null,?,?,?,?,?,null,?,"
			+ "?,null,null,null,?,null,null,null,null,null,null,null,?);";


	public int addUser(User user) throws SQLException {
			PreparedStatement ps = getCon().prepareStatement(INSERT_USER_INTO_DB,
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setDate (6, user.getDateOfBirth());
			ps.setInt(7, user.getGender().getIndex());
			ps.setInt(8, user.getCity().getId());
			ps.setDate(9, java.sql.Date.valueOf(user.getDateOfRegistration().toLocalDate()));
				ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		

	}
	public void changeUserFirstName (int userID){
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_FIRST_NAME);
			System.out.println("pls enetr the new name");
			Scanner  sc = new Scanner(System.in);
			String name = sc.next();
			
			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void changeUserLastName (int userID){
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_LAST_NAME);
			System.out.println("pls enetr the new name");
			Scanner  sc = new Scanner(System.in);
			String name = sc.next();
			
			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void changeUserUserName (int userID){
		try {
			PreparedStatement ps = getCon().prepareStatement(UPDATE_USERS_USER_NAME);
			System.out.println("pls enetr the new name");
			Scanner  sc = new Scanner(System.in);
			String name = sc.next();
			
			ps.setString(1, name);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}