package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.ReferenceException;
import ittalents.couchshare.model.exceptions.UserException;

public class ReferenceDAO extends AbstractDBConnDAO {

	public void addReference(Reference reference) throws ReferenceException, PostException{
		if (reference != null) {
			try {
				int i=new PostDAO().addPost(new Post(reference.getContent(), reference.getAuthor()));
				PreparedStatement ps = getCon().prepareStatement("insert into reference values(?,?,?,?);");
				ps.setBoolean(1, reference.isWouldReccomend());
				ps.setInt(2, gitIdFromString(reference.getTravilingType()));
				ps.setInt(3, i);
				ps.setInt(4, reference.getReciever().getId());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new ReferenceException("Can't add an post", e);
			}
		}
	}

//	public Reference getReferenceById(int userId) throws UserException, ReferenceException {
//		try {
//			PreparedStatement ps = getCon().prepareStatement("select *  from reference r join post p on (p.id=r.post_id)where r.receiver = "+userId+";");
//			// ps.setInt(1, userId);
//			ResultSet result = ps.executeQuery();
//			result.next();
//			boolean wouldReccomend = result.getBoolean(1);
//			String travilingType = getTravilingTypeById(result.getInt(2));
//			
//
//			User reciever = new UserDAO().getUserById(result.getInt(4));
//			String content = result.getString(6);
//			User author = new UserDAO().getUserById(result.getInt(8));
//
//			return new Reference(wouldReccomend, travilingType, reciever, content, author);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new ReferenceException("Can't find an Reference with ID : " + userId, e);
//		}
//	}
	
	

	public String getTravilingTypeById(int id) {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = getCon().createStatement();
			result = stmt.executeQuery("select type from traviling_type where id = " + id + ";");
			result.next();
			return result.getString("type");

		} catch (Exception e) {
			new UserException("there is no such traviling_type id", e);
		}
		return "null";
	}

	private int gitIdFromString(String TravilingType) {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = getCon().createStatement();
			result = stmt.executeQuery("select id from traviling_type where type like '%" + TravilingType + "%';");
			result.next();
			return result.getInt("id");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;

	}

}
