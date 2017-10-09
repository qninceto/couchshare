package ittalents.couchshare.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mysql.cj.api.xdevapi.Result;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.EventException;
import ittalents.couchshare.model.exception.UserException;
import itttalents.couchshare.model.interfaces.IEventDAO;
import itttalents.couchshare.model.interfaces.IUserDao;

public class EventDAO extends AbstractDBConnDAO implements IEventDAO {

	private static final String SELECT_FROM_EVENTS_ORDER_BY_TIME_OF_EVENT = "SELECT * FROM events order by time_of_event;";
	private static final String INSERT_EVENT_INTO_DB = "insert into events values (null,?,?,?,?,?,?,?);";
	private static final String UPDATE_EVENT_INFO = "UPDATE users SET max_nimber_participants=?, "
			+ "name=?, time_of_event=?, description=?, address=?, location_city=?, WHERE id= ?;";

	public int addEvent(Event event) throws EventException {
		try {
			PreparedStatement ps = getCon().prepareStatement(INSERT_EVENT_INTO_DB,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, event.getMaxNumberParticipants());
			ps.setString(2, event.getName());
			ps.setInt(3, event.getCreator().getId());
			ps.setDate(4, event.getTimeOTheEvent());// TODO check this later!
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

	public void updateEvent(int eventId, int max_part, String name, Date date, String desc, String addr, String city,
			String country) throws EventException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(UPDATE_EVENT_INFO);

			ps.setInt(1, max_part);
			ps.setString(2, name);
			ps.setDate(3, date);
			ps.setString(4, desc);
			ps.setString(5, addr);
			ps.setInt(6, AbstractCityDAO.getCityId(city, country));

			ps.setInt(7, eventId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Cannot update Event", e);
		}

	}

	public boolean cancelEvent(int eventId) throws EventException {
		// TODO ARE YOU SURE QUESTION?
		Statement statement;
		try {
			statement = getCon().createStatement();
			if (statement.executeUpdate("delete from events  where id="+eventId) > 0) {
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
			ResultSet resultSet = statement.executeQuery(SELECT_FROM_EVENTS_ORDER_BY_TIME_OF_EVENT);
			IUserDao userdao = new UserDAO();

			while (resultSet.next()) {
				allEventsInCity.add(new Event(resultSet.getInt(2), resultSet.getString("name"),
						userdao.getUserById(resultSet.getInt(4)), resultSet.getDate(5), resultSet.getString(6),
						resultSet.getString(7), city, country));
			}
			return allEventsInCity;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException(e);
		}
	}

	public List<Event> getAllEventsHostedByUser(int userId) throws UserException, EventException{
		List<Event> allEventsFromUser = new ArrayList<Event>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM events where creator="+userId+" order by time_of_event;");
			IUserDao userdao = new UserDAO();

			while (resultSet.next()) {
				String cityName = AbstractCityDAO.getCityName(resultSet.getInt(8));
				String countryName = AbstractCityDAO.getCountryName(resultSet.getInt(8));
				
				allEventsFromUser.add(new Event(resultSet.getInt(2), resultSet.getString("name"),
						userdao.getUserById(resultSet.getInt(4)), resultSet.getDate(5), resultSet.getString(6),
						resultSet.getString(7), cityName,countryName));
			}
			return allEventsFromUser;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException( e);
		}
	}

	
	public List<User> listOfEventAttendants(int eventId) throws UserException, EventException{
		List<User> listOfEventAttendants = new ArrayList<User>();
		Statement statement;
		try {
			statement = getCon().createStatement();
			ResultSet resultSet=statement.executeQuery("select * from events_participants where events_id="+eventId+";");
			IUserDao userdao = new UserDAO();
			
			while (resultSet.next()) {
				int userId=resultSet.getInt(1);
				listOfEventAttendants.add(userdao.getUserById(userId));
			}
			return listOfEventAttendants;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException( e);
		}
	}
}
	//write a post
	//show list of posts
	
	

