package ittalents.couchshare.model.POJO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

public class Event {
	private Collection<User> participants;
	private int maxNumberParticipants;
	private String name;
	private User organizer;
	private String description;

	// take from a map???????
	private String address;

	private City location;

	private LocalDateTime timeOTheEvent;

	private Collection<Post> comments;

	private File pictureOfTheEvent;

//constructor for the event *2
	public Event(User organizer, String name, City location, LocalDateTime timeOTheEvent, int maxNumberParticipants,
			String description, String address, File pictureOfTheEvent) {

		setName(name);
		setMaxNumberParticipants(maxNumberParticipants);
		setOrganizer(organizer);
		setDescription(description);
		setAddress(address);
		setLocation(location);
		setTimeOTheEvent(timeOTheEvent);
		setPictureOfTheEvent(pictureOfTheEvent);
	}

	// method for validation for picture start need to be checked *1
	private boolean validPic(File pic) {
		try {
			BufferedImage image = ImageIO.read(pic);
			if (image == null) {
				System.out.println("The file" + name + "could not be opened , it is not an image");
				return false;

			}
		} catch (IOException ex) {
			System.out.println("The file" + name + "could not be opened , an error occurred.");
			return false;
		}
		return true;
	}
	// method for validation for picture end

	public void setPictureOfTheEvent(File pictureOfTheEvent) {
		if (validPic(pictureOfTheEvent) && pictureOfTheEvent != null)

			this.pictureOfTheEvent = pictureOfTheEvent;
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

	public void setOrganizer(User organizer) {
		if (organizer != null) {
			this.organizer = organizer;
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

}
