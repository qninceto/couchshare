package ittalents.couchshare.model.interfaces;

import java.util.List;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.UserException;

public interface IEventDAO {
	public int addEvent(Event event) throws EventException;
//	public void updateEvent(int eventId,Event event ) throws EventException;
	public boolean removeEvent(int eventId) throws EventException;
	public List<Event> getAllEventsInCity(String city, String country) throws UserException, EventException;
	public List<Event> getAllEventsHostedByUser(int userId) throws UserException, EventException;
	public List<User> listOfEventAttendants(int eventId) throws UserException, EventException;
}
