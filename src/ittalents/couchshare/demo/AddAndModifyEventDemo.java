package ittalents.couchshare.demo;

import java.util.List;
import java.util.Scanner;

import ittalents.couchshare.model.DAO.EventDAO;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.EventException;
import ittalents.couchshare.model.exceptions.UserException;

public class AddAndModifyEventDemo {
	//add event
	//leave event
	
	//join event	
/*users:
 * 1
2
4
5
8
9
 */

	/*events
	 * 1
2
7
8
9
10
11
12
13
14
	 */
	
	public static void main(String[] args) throws UserException, EventException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int userId = sc.nextInt();
		System.out.println("Enter event id: ");
		int eventId = sc.nextInt();
		new UserDAO().joinEvent(eventId, userId);
		System.out.println("-------------");
		Event e =new EventDAO().getEventById(eventId);
		System.out.println("Name: "+e.getName());
		System.out.println("Address: "+e.getAddress());
		System.out.println("Description: "+e.getDescription());
		System.out.println("Max number of participants: "+e.getMaxNumberParticipants());
		System.out.println("Time of the event: "+e.getTimeOTheEvent());
		System.out.println("Organizer: "+e.getCreator());
		System.out.println();
		System.out.println("All attendants :");
		List<User> users = new EventDAO().listOfEventAttendants(e.getId());
		for (User u2: users) {
			System.out.println(u2);
		}
		System.out.println("*************");
	}
}
