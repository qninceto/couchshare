package ittalents.couchshare.model.POJO;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
public class User {
	// intialize in the constructor:
//	private PersonalInformation myPersonalInformation;
//	private HomeInformation myHomeInformation;



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
		private enum HostingAvailability {
		MEET_UP(1), ACCEPTING(2), NOT_ACCEPTING(3), MAYBE_ACCEPTING(4);
			private int index;
			private HostingAvailability(int index) {
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
	private Date dateOfBirth;
	private Gender gender;
	private String ocupation;
	private String eduction;
	private City city;
	private String aboutMe;
	private String resonsToSurf;
	private String interests;
	private int maxGuests;
	private boolean smokingAllowed;
	private HostingAvailability currentHostingAvailability;
	private LocalDateTime dateOfRegistration;
	
	
	public User(int id, String userName, String userPassword,
			String email, String firstName, String lastName,
			Date dateOfBirth, Gender gender, City city) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		
		this.dateOfRegistration = LocalDateTime.now();
	}


	public int getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public String getEmail() {
		return email;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPhone() {
		return phone;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public Gender getGender() {
		return gender;
	}


	public String getOcupation() {
		return ocupation;
	}


	public String getEduction() {
		return eduction;
	}


	public City getCity() {
		return city;
	}


	public String getAboutMe() {
		return aboutMe;
	}


	public String getResonsToSurf() {
		return resonsToSurf;
	}


	public String getInterests() {
		return interests;
	}


	public int getMaxGuests() {
		return maxGuests;
	}


	public boolean isSmokingAllowed() {
		return smokingAllowed;
	}


	public HostingAvailability getCurrentHostingAvailability() {
		return currentHostingAvailability;
	}


	public LocalDateTime getDateOfRegistration() {
		return dateOfRegistration;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}


	public void setEduction(String eduction) {
		this.eduction = eduction;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}


	public void setResonsToSurf(String resonsToSurf) {
		this.resonsToSurf = resonsToSurf;
	}


	public void setInterests(String interests) {
		this.interests = interests;
	}


	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}


	public void setSmokingAllowed(boolean smokingAllowed) {
		this.smokingAllowed = smokingAllowed;
	}


	public void setCurrentHostingAvailability(HostingAvailability currentHostingAvailability) {
		this.currentHostingAvailability = currentHostingAvailability;
	}
	
	
	

}
