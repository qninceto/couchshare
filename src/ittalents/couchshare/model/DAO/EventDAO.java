package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.UserException;
import ittalents.couchshare.model.interfaces.IEventDAO;
import ittalents.couchshare.model.interfaces.IUserDao;

public class EventDAO extends AbstractDBConnDAO implements IEventDAO {

	// private static final String SELECT_FROM_EVENTS_ORDER_BY_TIME_OF_EVENT =
	// "SELECT * FROM events order by time_of_event;";
	private static final String INSERT_EVENT_INTO_DB = "insert into events values (null,?,?,?,?,?,?,?);";
	private static final String UPDATE_EVENT_INFO = "UPDATE events SET max_nimber_participants=?, name=?, time_of_event=?, description=?, address=?, location_city=? WHERE id= ?;";
	private static final String SELECT_FROM_EVENTS_BY_ID = "select *from events where id =";;

	public int addEvent(Event event) throws EventException {
		try {
			PreparedStatement ps = getCon().prepareStatement(INSERT_EVENT_INTO_DB,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, event.getMaxNumberParticipants());
			ps.setString(2, event.getName());
			ps.setInt(3, event.getCreator().getId());
			ps.setTimestamp(4, event.getTimeOTheEvent());// TODO check this later!
			ps.setString(5, event.getDescription());
			ps.setString(6, event.getAddress());
			ps.setInt(7, AbstractCityDAO.getCityId(event.getCity(), event.getCountry()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Cannot create event", e);
		}

	}

	public void updateEvent(Event event) throws EventException, UserException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(UPDATE_EVENT_INFO);
			// Event event=getEventById(eventId);
			ps.setInt(1, event.getMaxNumberParticipants());
			ps.setString(2, event.getName());
			ps.setTimestamp(3, event.getTimeOTheEvent());
			ps.setString(4, event.getDescription());
			ps.setString(5, event.getAddress());
			ps.setInt(6, AbstractCityDAO.getCityId(event.getCity(), event.getCountry()));

			ps.setInt(7, event.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Cannot update Event", e);
		}

	}

	public Event getEventById(int eventId) throws EventException, UserException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_FROM_EVENTS_BY_ID + eventId);

			resultSet.next();

			int id = resultSet.getInt(1);
			int maxNumberParticipants = resultSet.getInt(2);
			String name = resultSet.getString(3);
			int creatorId = resultSet.getInt(4);
			Timestamp timeOTheEvent = resultSet.getTimestamp(5);
			String description = resultSet.getString(6);
			String address = resultSet.getString(7);
			int cityId = resultSet.getInt(8);

			String city = AbstractCityDAO.getCityName(cityId);
			String country = AbstractCityDAO.getCountryName(cityId);
			User creator = new UserDAO().getUserById(creatorId);

			return new Event(id, maxNumberParticipants, name, creator, timeOTheEvent, description, address, city,
					country);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Can't find a Event with ID : " + eventId, e);
		}
	}

	public boolean removeEvent(int eventId) throws EventException {
		Statement statement;
		try {
			statement = getCon().createStatement();
			if (statement.executeUpdate("delete from events  where id=" + eventId) > 0) {
				return true;
			}
			throw new EventException("This event doesnt exist");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Cannot cancel Event", e);
		}
	}

	public List<Event> getAllEventsInCity(String city, String country) throws UserException, EventException {
		List<Event> allEventsInCity = new ArrayList<Event>();
		try {
			Statement statement = getCon().createStatement();
			int cityId = AbstractCityDAO.getCityId(city, country);
			System.out.println(cityId);//////////////
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM events where location_city = " + cityId + " order by time_of_event;");
			IUserDao userdao = new UserDAO();

			while (resultSet.next()) {
				allEventsInCity.add(new Event(resultSet.getInt(1),resultSet.getInt(2), resultSet.getString("name"),
						userdao.getUserById(resultSet.getInt(4)), resultSet.getTimestamp(5), resultSet.getString(6),
						resultSet.getString(7), city, country));
			}
			return allEventsInCity;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException(e);
		}
	}

	public List<Event> getAllEventsHostedByUser(int userId) throws UserException, EventException {
		List<Event> allEventsFromUser = new ArrayList<Event>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM events where creator=" + userId + " order by time_of_event;");
			IUserDao userdao = new UserDAO();

			while (resultSet.next()) {
				String cityName = AbstractCityDAO.getCityName(resultSet.getInt(8));
				String countryName = AbstractCityDAO.getCountryName(resultSet.getInt(8));

				allEventsFromUser.add(new Event(resultSet.getInt(2), resultSet.getString("name"),
						userdao.getUserById(resultSet.getInt(4)), resultSet.getTimestamp(5), resultSet.getString(6),
						resultSet.getString(7), cityName, countryName));
			}
			return allEventsFromUser;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException(e);
		}
	}

	public List<User> listOfEventAttendants(int eventId) throws UserException, EventException {
		List<User> listOfEventAttendants = new ArrayList<User>();
		Statement statement;
		try {
			statement = getCon().createStatement();
			System.out.println("eventid"+eventId);
			ResultSet resultSet = statement
					.executeQuery("select * from events_participants where events_id=" + eventId + ";");
			IUserDao userdao = new UserDAO();

			while (resultSet.next()) {
				int userId = resultSet.getInt(1);
				listOfEventAttendants.add(userdao.getUserById(userId));
			}
			return listOfEventAttendants;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException(e);
		}
	}

	public void addPostToEvent(int eventId, Post post) throws EventException, PostException {
		Statement statement;
		try {
			statement = getCon().createStatement();

			new PostDAO().addPost(post);
			int passed = statement
					.executeUpdate("insert into events_comments values(" + eventId + "," + post.getId() + ");");
			if (passed == 0) {
				// TODO remove the post from DB
				throw new EventException("couldnt add post");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("couldnt add post", e);
		}
	}

	// public void removePostFromEvent(int eventId, int postId, int authorId) {};
	// public void updatePostFromEvent(int eventId, int postId, int authorId) {};

	public List<Post> showAllPostsInEvent(int eventId) throws UserException, EventException, PostException {
		List<Post> listOfPostsInEvent = new ArrayList<Post>();
		Statement statement;
		try {
			statement = getCon().createStatement();
			ResultSet resultSet = statement
					.executeQuery("select post_id from events_comments where events_id = " + eventId + ";");

			while (resultSet.next()) {
				int postId = resultSet.getInt(1);
				listOfPostsInEvent.add(new PostDAO().getPostById(postId));
			}
			return listOfPostsInEvent;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException(e);
		}
	}

}
