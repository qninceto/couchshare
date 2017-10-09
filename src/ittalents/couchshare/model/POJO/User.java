package ittalents.couchshare.model.POJO;

import java.sql.Date;
import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;

public class User {
	
	private int id;
	private String userName;
	private String userPassword;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	//tozi date format li????
	private Date dateOfBirth;
	private String gender;
	private String ocupation;
	private String eduction;
	private String city;
	private String aboutMe;
	private String resonsToSurf;
	private String interests;
	private int maxGuests;
	private boolean smokingAllowed;
	private String currentHostingAvailability;
	private Timestamp dateOfRegistration;

	public User(int id, String userName, String userPassword, String email, String firstName, String lastName,

			Date dateOfBirth, String gender, String city) {
		this(userName, userPassword, email, firstName, lastName, dateOfBirth, gender, city);
		this.id = id;
	}

	public User(String userName, String userPassword, String email, String firstName, String lastName, Date dateOfBirth,

			String gender, String city) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		//tova vry6ta data i 4asa na registraciq v pravilen format:
		this.dateOfRegistration = new Timestamp(System.currentTimeMillis());
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

	public String getGender() {
		return gender;
	}

	public String getOcupation() {
		return ocupation;
	}

	public String getEduction() {
		return eduction;
	}

	public String getCity() {
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

	public String getCurrentHostingAvailability() {
		return currentHostingAvailability;
	}

	public Timestamp getDateOfRegistration() {
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

	public void setCity(String city) {
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

	public void setCurrentHostingAvailability(String currentHostingAvailability) {
		this.currentHostingAvailability = currentHostingAvailability;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", city=" + city + "]";

	}

}
