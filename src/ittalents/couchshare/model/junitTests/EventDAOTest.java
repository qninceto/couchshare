package ittalents.couchshare.model.junitTests;


import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

import ittalents.couchshare.model.DAO.EventDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.UserException;

public class EventDAOTest {

	@Test
	public void testCreateEvent() throws EventException, UserException {
		//addevent
		EventDAO event = new EventDAO();
		Date d =Date.valueOf("1987-01-25");
		UserDAO userdao= new UserDAO();
		User user =userdao.getUserById(1);
//		User user = new User(2,"pesho_pi4a", "123456", "pesho_pi4a@abv.bg", "pesho", "petrov", d, "Male", "Burgas");
		Timestamp date = Timestamp.valueOf("2017-10-12 00:00:00");
		
		event.addEvent(new Event(10,"birthday party",user,date,"qnaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","nqkyde tam","Burgas","Bulgaria"));
		
		
	}
	@Test
	public void testUpdateEvent() throws EventException, UserException {
		Event event = new EventDAO().getEventById(13);
		event.setName("qkata dupara");
		event.setDescription("ej tuka go promenih nnnnnnnnnnnnnnnn");
		new EventDAO().updateEvent(event);
		 
	}
}
