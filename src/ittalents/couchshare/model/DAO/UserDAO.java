package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDBConnDAO {

	private static final String INSERT_USER_INTO_DB = "INSERT into users values(null,?,?,?,?,?);";

	public int addUser() throws SQLException {
			PreparedStatement ps = getCon().prepareStatement(INSERT_USER_INTO_DB,
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "Qna");
			ps.setString(2, "Banana");
			ps.setString(3, "otchaqna69");
			ps.setString(4, "otchaqna69@abv.bg");
			ps.setString(5, "123456qna");
			

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		

	}

}