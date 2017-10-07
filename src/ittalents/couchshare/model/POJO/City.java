package ittalents.couchshare.model.POJO;

import java.io.File;
import java.util.*;

public class City {
	private String name;
	private String description;
	private Collection<User> localHosts;
	private Collection<User> upcomingTravellers;
	private Collection<Event> events;
	private File picture;
//	private Country country???? composition//only one country//set once in the constructor
}
