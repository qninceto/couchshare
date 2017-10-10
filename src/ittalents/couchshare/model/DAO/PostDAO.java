package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.UserException;

public class PostDAO extends AbstractDBConnDAO {
	

	public int addPost(Post post) throws PostException {
		if (post != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement("insert into post values(null,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, post.getContent());
				ps.setTimestamp(2, post.getTimeOfPosting());
				ps.setInt(3, post.getAuthor().getId());

				ps.executeUpdate();

				// get last inserted id
				ResultSet id = ps.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new PostException("Can't add an post", e);
			}
		}
		return 0;
	}
	
	public Post getPostById (int postId) throws PostException, UserException  {
		try {
			PreparedStatement ps = getCon().prepareStatement("select *from post where id ="+ postId);
//			ps.setInt(1, userId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String content = result.getString(2);
			Timestamp timeOfPosting = result.getTimestamp(3);
			
			User author = new UserDAO().getUserById(result.getInt(4));
			
			return new Post(id, content, author,timeOfPosting);
		} catch (SQLException e) {
			e.printStackTrace();
		throw new PostException("Can't find a Post with ID : " + postId, e);
		}
	}

}
