package ittalents.couchshare.model.POJO;

import java.io.File;
import java.util.*;

public class City {
	private int id;
	private String name;
	private String description;
	private   Country country;
	
	
	public City(String name, Country country){
		this.name = name;
		this.country = country;
	}
	public City(int id, String name, Country country) {
		this(name, country);
		this.id = id;

	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Country getCountry() {
		return country;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
//	private Collection<User> localHosts;
//	private Collection<User> upcomingTravellers;
//	private Collection<Event> events;
//	private File picture;
//	private Country country???? composition//only one country//set once in the constructor
}
