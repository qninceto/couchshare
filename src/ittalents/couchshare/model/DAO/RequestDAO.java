package ittalents.couchshare.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Request;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.RequestException;
import ittalents.couchshare.model.exceptions.UserException;
import ittalents.couchshare.model.interfaces.IRequestDAO;

public class RequestDAO extends AbstractDBConnDAO implements IRequestDAO {
	private static final String SELECT_FROM_REQUESTS_BY_ID = "select *from requests where post_id =";
	private static final String SELECT_ALL_REQUESTS_SENT_BY_USER = "select r.post_id from requests r join post p on (r.post_id=p.id) where p.author=";
	private static final String ADD_EVENT_TO_DB = "insert into requests values(?,?,?,?,?,?,?);";
	private static final int NUMBER_OF_PENDING_STATUS_IN_DB = 3;
	private static final String SELECT_ALL_REQUESTS_RECEIVED_BY_USER = "select post_id  from requests  j  where receiver=";
	
	/*
	 * TODO create a request send message
	 */
	
	public int addRequest(Request request) throws PostException, RequestException {
		if (request != null) {
			if (!request.getAuthor().equals(request.getReceiver())) {
				// TODO validate the date to make sure its in the future!!!!
				try {
					Post postOfRequest = new Post(request.getContent(), request.getAuthor());
					int postId = new PostDAO().addPost(postOfRequest);
					//TODO if it fails--->remove the post from db!!!--->how?
					PreparedStatement ps = getCon().prepareStatement(ADD_EVENT_TO_DB);

					ps.setDate(1, request.getStartDate());
					ps.setDate(2, request.getEndDate());
					ps.setInt(3, request.getNumberOfTravellers());
					ps.setInt(4, postId);
					ps.setBoolean(5, request.isExpired());
					ps.setInt(6, NUMBER_OF_PENDING_STATUS_IN_DB);
					ps.setInt(7, request.getReceiver().getId());

					ps.executeUpdate();

					return postId;

				} catch (SQLException e) {
					e.printStackTrace();
					throw new RequestException("Can't add a request", e);
				}
			} else {
				throw new RequestException("author cannot be receiver at the same time!");
			}
		}
		return 0;
	}

	public boolean updateRequstToAccepted(Request request) throws RequestException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			if (statement.executeUpdate("update requests set id_request_status=1 where post_id="+request.getId() ) > 0) {
				return true;
			}
			throw new RequestException("This request doesnt exist");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RequestException("Cannot accept request", e);
		}
	}

	public boolean updateRequstToDenied(Request request) throws RequestException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			if (statement.executeUpdate("update requests set id_request_status=2 where post_id="+request.getId() ) > 0) {
				return true;
			}
			throw new RequestException("This request doesnt exist");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RequestException("Cannot accept request", e);
		}
	}

	public Request getRequestById(int reqId) throws RequestException, PostException, UserException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			ResultSet resultSet = statement
					.executeQuery(SELECT_FROM_REQUESTS_BY_ID+ reqId);

			resultSet.next();
			
			Date startDate = resultSet.getDate(1);
			Date endDate = resultSet.getDate(2);
			int numberOfTravellers = resultSet.getInt(3);
			int postId =resultSet.getInt(4);
			boolean isExpired=resultSet.getBoolean(5);
			int acceptedStatus =resultSet.getInt(6);
			String status="";
			switch(acceptedStatus) {
			case 1:
				status="accepted";
				break;
			case 2:
				status="rejected";
				break;
			case 3:
				status="pending";
				break;
			}
			int receiverId =resultSet.getInt(7);
			
			Post post =new PostDAO().getPostById(postId);
			String content = post.getContent();
			User author =post.getAuthor();
			
			User receiver = new UserDAO().getUserById(receiverId);
			
			return new Request(content, author, startDate, endDate, receiver, numberOfTravellers, status, isExpired,postId);
		} catch (SQLException e) {
			e.printStackTrace();
		throw new RequestException("Can't find a Request with ID : " + reqId, e);
		}
	}

	public List<Request> getListOfRequestsSentFromUser(int userId) throws RequestException, PostException, UserException{
		List<Request> getListOfRequestsSentFromUser = new ArrayList<Request>();
		Statement statement;
		try {
			statement = getCon().createStatement();
			ResultSet resultSet = statement
					.executeQuery(SELECT_ALL_REQUESTS_SENT_BY_USER +  userId + ";");

			while (resultSet.next()) {
				int postId = resultSet.getInt(1);
				getListOfRequestsSentFromUser.add(getRequestById(postId));
			}
			return getListOfRequestsSentFromUser;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RequestException(e);
		}
	}

	public List<Request> getListOfRequestsReceivedByUser(int userId) throws RequestException, PostException, UserException{
		List<Request> getListOfRequestsReceivedByUser = new ArrayList<Request>();
		Statement statement;
		try {
			Connection c = AbstractDBConnDAO.getCon();
			statement = c.createStatement();
			ResultSet resultSet = statement
					.executeQuery(SELECT_ALL_REQUESTS_RECEIVED_BY_USER +  userId + ";");

			while (resultSet.next()) {
				int postId = resultSet.getInt(1);
				getListOfRequestsReceivedByUser.add(getRequestById(postId));
			}
			return getListOfRequestsReceivedByUser;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RequestException(e);
		}
	}

}
