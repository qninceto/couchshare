package itttalents.couchshare.model.interfaces;

import java.sql.Date;
import java.util.List;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.EventException;
import ittalents.couchshare.model.exception.UserException;

public interface IEventDAO {
	public int addEvent(Event event) throws EventException;
	public void updateEvent(int eventId, int max_part, String name, Date date, String desc, String addr, String city,
			String country) throws EventException;
	public boolean cancelEvent(int eventId) throws EventException;
	public List<Event> getAllEventsInCity(String city, String country) throws UserException, EventException;
	public List<Event> getAllEventsHostedByUser(int userId) throws UserException, EventException;
	public List<User> listOfEventAttendants(int eventId) throws UserException, EventException;
}
