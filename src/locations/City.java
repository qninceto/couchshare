package locations;

import java.io.File;
import java.util.*;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.POJO.User;

public class City {
	private String name;
	private String description;
	private Collection<User> localHosts;
	private Collection<User> upcomingTravellers;
	private Collection<Event> events;
	private File picture;
//	private Country country???? composition//only one country//set once in the constructor
}
