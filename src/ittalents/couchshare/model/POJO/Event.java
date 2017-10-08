package ittalents.couchshare.model.POJO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

public class Event {
	// private Collection<User> participants;
	// private Collection<Post> comments;
	// private File pictureOfTheEvent;
	private int id;
	private int maxNumberParticipants;
	private String name;
	private User creator;
	private LocalDateTime timeOTheEvent;
	private String description;
	private String address;
	private City location;

	public Event(int id, int maxNumberParticipants, String name, User creator, LocalDateTime timeOTheEvent,
			String description, String address, City location) {

		setId(id);
		setName(name);
		setMaxNumberParticipants(maxNumberParticipants);
		setCreator(creator);
		setTimeOTheEvent(timeOTheEvent);
		setDescription(description);
		setAddress(address);
		setLocation(location);
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
		if (description != null && description.length() >= 23) {
			this.description = description;
		} else {
			System.out.println("The description of the event should at least 24 characters ");
		}
	}

	public void setAddress(String address) {
		if (address != null) {
			this.address = address;
		}
	}

	public void setLocation(City location) {
		if (location != null) {
			this.location = location;
		}
	}

	public void setTimeOTheEvent(LocalDateTime timeOTheEvent) {
		if (timeOTheEvent != null && timeOTheEvent.isAfter(LocalDateTime.now())) {
			this.timeOTheEvent = timeOTheEvent;
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

	public void setId(int id) {
		this.id = id;
	}

}
