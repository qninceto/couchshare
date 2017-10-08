package ittalents.couchshare.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.exception.EventException;
import itttalents.couchshare.model.interfaces.IEventDAO;

public class EventDAO extends AbstractDBConnDAO implements IEventDAO {

	private static final String INSERT_EVENT_INTO_DB = "insert into events values (null,?,?,?,?,?,?,?);";
	private static final String UPDATE_EVENT_INFO = "UPDATE users SET max_nimber_participants=?, "
			+ "name=?, time_of_event=?, description=?, address=?, location_city=?, WHERE id= ?;";

	// insert into events
	// values (null,'10','birthday party',1,'2017-10-12',null,'nqkyde tam',2);

	public int createEvent(Event event) throws EventException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(INSERT_EVENT_INTO_DB, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, event.getMaxNumberParticipants());
			ps.setString(2, event.getName());
			ps.setInt(3, event.getCreator().getId());
			ps.setDate(4, event.getTimeOTheEvent());// TODO check this later!
			ps.setString(5, event.getDescription());
			ps.setString(6, event.getAddress());
			ps.setInt(7, event.getLocation().getId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EventException("Cannot create event", e);
		}

	}

	public void updateEvent(int eventId) {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(UPDATE_EVENT_INFO);
			

			ps.setInt(1, event.getMaxNumberParticipants());
			ps.setString(2, event.getName());
			ps.setInt(3, event.getCreator().getId());
			ps.setDate(4, event.getTimeOTheEvent());// TODO check this later!
			ps.setString(5, event.getDescription());
			ps.setString(6, event.getAddress());
			ps.setInt(7, event.getLocation().getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
