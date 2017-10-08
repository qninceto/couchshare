package ittalents.couchshare.model.POJO;


public class City {
	private int id;
	private String name;
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
	public Country getCountry() {
		return country;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
//	private Collection<User> localHosts;
//	private Collection<User> upcomingTravellers;
//	private Collection<Event> events;
//	private File picture;
//	private Country country???? composition//only one country//set once in the constructor
}
