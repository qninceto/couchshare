package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ittalents.couchshare.model.POJO.MessageBox;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.exceptions.PostException;

public class MessageBoxDAO extends AbstractDBConnDAO{
	public void addMessageBox(MessageBox messageBox) throws PostException {
		if (messageBox != null) {
			try {
				int i=new PostDAO().addPost(new Post(messageBox.getContent(), messageBox.getAuthor()));
				PreparedStatement ps = getCon().prepareStatement("insert into message_boxes values(?,?);");
				ps.setInt(1, messageBox.getReceiver().getId());
				ps.setInt(2, i);
				

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				// throw new MessegeBoxException("Can't add an MessageBox", e);
			}
		}
	}
	

}
