package ittalents.couchshare.model.POJO;

import java.sql.Timestamp;

public class Event {
	private int id;
	private int maxNumberParticipants;
	private String name;
	private User creator;
	private Timestamp timeOfTheEvent;
	private String description;
	private String address;
	private String city;
	private String country;

	public Event(int maxNumberParticipants, String name, User creator, Timestamp timeOTheEvent, String description,
			String address, String city, String country) {
		setName(name);
		setMaxNumberParticipants(maxNumberParticipants);
		setCreator(creator);
		setTimeOTheEvent(timeOTheEvent);
		setDescription(description);
		setAddress(address);
		setCity(city);
		setCountry(country);
	}

	public Event(int id, int maxNumberParticipants, String name, User creator, Timestamp timeOTheEvent, String description,
			String address, String city, String country) {
		this(maxNumberParticipants, name, creator, timeOTheEvent, description, address, city,country);
		this.id = id;
	}

	public void setMaxNumberParticipants(int maxNumberParticipants) {
		if (maxNumberParticipants > 1) {
			this.maxNumberParticipants = maxNumberParticipants;
		} else {

			System.out.println("Limit Attendees should be more than 1 ");
		}
	}

	public void setName(String name) {
		if (name != null && name.length() >= 7) {
			this.name = name;
		} else {
			System.out.println("The name of the event should at least 8 characters ");
		}
	}

	public void setDescription(String description) {
//		if (description != null && description.length() >= 23) {
			this.description = description;
//		} else {
//			System.out.println("The description of the event should at least 24 characters ");
//		}
	}

	public void setAddress(String address) {
		if (address != null) {
			this.address = address;
		}
	}

	public void setCity(String location) {
		if (location != null) {
			this.city = location;
		}
	}

	public void setTimeOTheEvent(Timestamp timeOTheEvent) {
		if (timeOTheEvent != null) {
			// validiraj:
			// && timeOTheEvent.isAfter(Date.valueOf())) {
			this.timeOfTheEvent = timeOTheEvent;
		} else {
			System.out.println("You can not have an event in the past");
		}
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public int getMaxNumberParticipants() {
		return maxNumberParticipants;
	}

	public String getName() {
		return name;
	}

	public Timestamp getTimeOTheEvent() {
		return timeOfTheEvent;
	}

	public String getDescription() {
		return description;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
