package ittalents.couchshare.model.junitTests;


import java.sql.Date;

import org.junit.Test;

import ittalents.couchshare.model.DAO.EventDAO;
import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.POJO.User.Gender;
import ittalents.couchshare.model.exception.EventException;

public class EventDAOTest {

	@Test
	public void testCreateEvent() throws EventException {
		//addevent
		EventDAO event = new EventDAO();
//		Country c = new Country(2, "Bulgaria");
//		City ci = new City(2, "Burgas", c);
		Date d =Date.valueOf("1987-01-25");
		User user = new User(1,"pesho_pi4a", "123456", "pesho_pi4a@abv.bg", "pesho", "petrov", d, Gender.M, "Burgas");
		Date date = Date.valueOf("2018-09-04");
		
		
		
		event.addEvent(new Event(10,"birthday party",user,date,"testjhhjhjhjgghxdtfghkjl;ghgghghhg","nqkyde tam","Burgas","Bulgaria"));
		
		
	}

}
