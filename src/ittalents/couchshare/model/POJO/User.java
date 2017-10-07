package ittalents.couchshare.model.POJO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
public class User {
	// intialize in the constructor:
//	private PersonalInformation myPersonalInformation;
//	private HomeInformation myHomeInformation;

//	private enum HostingAvailability {
//		MEET_UP, ACCEPTING, NOT_ACCEPTING, MAYBE_ACCEPTING
//	}

//	private HostingAvailability currentAvailability;

//	private Collection<File> myPhotoes;
//	private File profilePicture;

//	private Collection<User> friends;
//	private Collection<Reference> myReferences ;
//
//	final LocalDateTime dateAndTimeOfRegistration;
	/*
	 * should be initialized in the costructor at the moment a new User object is
	 * instatntiated when a user is submitting the registration form
	 */

//	private LocalDateTime lastBeingOnline;

//	private enum UserStatus {
//		ACCEPTING_GUESTS, NON_ACCEPTING_GUESTS, MAYBE, WANTS_TO_HANG_OUT
//	}

//	private UserStatus currentStatus;

	// collections:
//	Collection<Event> attendingEvents;
//	Collection<Event> hostingEvents;
//	Collection<MessageBox> inbox;
//	Collection<Request> currentHostsRequests;
//	Collection<Request> currentSurfersRequests;
//	Collection<Reference> myReferences;
	
	
	
	///functionalities:

	// requesting!!!!
//	public  void offerToHost() {
//
//	}
//
//	public  void requestToStay() {
//
//	}
//
//	public  void acceptRequest() {
//		// a request should have status-pending,accepted,rejected
//	}
//
//	public  void rejectRequest() {
//
//	}
//	
//	/* sendOffer
//	 * rejectOffer
//	 * acceptOffer
//	 */
//
//	// events methods
//	public  void createEvent() {
//
//	}
//
//	public  void joinEvent() {
//
//	}
//
//	public  void inviteUsersToEvent() {
//
//	}
//
//	public  void postInEvent() {
//
//	}
//
//	// refernce
//	public  void referenceUser() {
//		// refrence to a host
//		// refrenece to a surfer
//		// personal reference
//	}
//	// addReferenceResponseMethod???
//
//	// messages
//	public  void sendMessage() {
//
//	}
//
//	public  void logOut() {
//
//	}
//
//	public void editMyProfile() {
//		// link to a page with a bunch of methods, changing the fields
//	}
	public enum Gender{
		 F(1),M(2),O(3);
		private int index;
		private Gender(int index) {
			this.index=index;
		}
		public int getIndex(){
			return this.index;
		}
	}

	private int id;
	private String userName ;
	private String userPassword;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private SimpleDateFormat dateOfBirth;
	private Gender gender;
	private String ocupation;
	private String eduction;
	
	

}
