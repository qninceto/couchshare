package ittalents.couchshare.demo;

import java.util.List;
import java.util.Scanner;

import ittalents.couchshare.model.DAO.EventDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.UserException;

public class ShowEventsInCityDemo {
	public static void main(String[] args) throws UserException, EventException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose a city");
		String cityName = sc.next();
		System.out.println("Choose a country");
		String countryName = sc.next();
		
		System.out.println("All events in "+cityName+","+countryName);
		System.out.println("------------------------------");
		List<Event> events=new EventDAO().getAllEventsInCity(cityName, countryName);
		for (Event e: events) {
			System.out.println("Name: "+e.getName());
			System.out.println("Address: "+e.getAddress());
			System.out.println("Description: "+e.getDescription());
			System.out.println("Max number of participants: "+e.getMaxNumberParticipants());
			System.out.println("Time of the event: "+e.getTimeOTheEvent());
			System.out.println("Organizer: "+e.getCreator());
			System.out.println();
			System.out.println("-----All attendants------------");
			List<User> users = new EventDAO().listOfEventAttendants(e.getId());
			for (User u2: users) {
				System.out.println(u2);
			}
			System.out.println("**********************");
			
		}
		
		System.out.println("Choose an user id to see all of the events he hosts:");
		int userId = sc.nextInt();
		User u=new UserDAO().getUserById(userId);
		System.out.println("All events of "+u+" :");
		System.out.println("------------------------------");
		List<Event> events2=new EventDAO().getAllEventsHostedByUser(userId);
		for (Event e: events2) {
			System.out.println("Name: "+e.getName());
			System.out.println("Address: "+e.getAddress());
			System.out.println("Description: "+e.getDescription());
			System.out.println("Max number of participants: "+e.getMaxNumberParticipants());
			System.out.println("Time of the event: "+e.getTimeOTheEvent());
			System.out.println("Organizer: "+e.getCreator());
			System.out.println("*********************");
		}
		
		
		
	}
	
	
	
	

}
