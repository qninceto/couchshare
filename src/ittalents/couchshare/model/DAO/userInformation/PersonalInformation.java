package ittalents.couchshare.model.DAO.userInformation;

import java.io.File;
import java.time.*;
import java.util.*;

import ittalents.couchshare.model.POJO.Language;
import ittalents.couchshare.model.POJO.User;
import locations.*;

public class PersonalInformation {

	// change field methods+ proper validations:
	private String password;
	private String email;
	private String userName = "";
	private String firstName = "";
	private String lastName = "";
	// generated from the birth year:
	private int age;
	private String phone;

	// initialize in the constructor
	// izbira se ot dropDowns
	// create functions!!!
	// taka li da q syhranqvam ili razbita?
	// tova dali go nqma gotovo v nqkoq biblioteka???
	private LocalDate dateOfBirth;

	public void changeMonthOfBirth(Month monthOfBirth) {

	}
	// same for the year and the day

	private enum Gender {
		FEMALE, MALE, OTHER
	}
	private Gender myGender;

	private String occupation = "";

	// Should the degree come from a data base
	// with the option to add new if its not in the list
	// searching by key Word???
	private String education = "";

	private Country currentCountry;
	private City currentCity;
	// the city is connected to the city!!!

	private Country homeCountry;
	private City hometown;

	// the city is connected to the city!!!
	/*
	 * chosing a language from data base add/remove language
	 */
	private Collection<Language> fluentLanguages;
	private Collection<Language> learningLanguages;

	private String aboutMe = "";
	private String whyIAmOnCouchsurfing = "";
	private String myInterests = "";
	private String myFavouriteBooksMooviesMusic = "";
	// more stuff comes here
	// ....

	private Collection<Country> visitedCountries;
	private Collection<Country> countriesIveLivedIn;

}
