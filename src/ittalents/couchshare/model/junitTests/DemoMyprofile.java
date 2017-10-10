package ittalents.couchshare.model.junitTests;

import java.sql.Date;
import java.util.List;

import ittalents.couchshare.model.DAO.DaoDemo;
import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exception.UserException;

public class DemoMyprofile {
	
	public static void main(String[] args) throws UserException {
		Date a =Date.valueOf("1987-01-25");
		int i=new UserDAO().registerUser(new User("wtf", "123456", "haflbjdnfjd",
				"firas", "saadi", a,"male", "sofia"));
		
		
		
		new UserDAO().UserAbout(i, "meet_up", "Telus", "NoWork", "nothing to say",
				"looking for advanger", "Music", "Russia", "Germany", "Bulgaian", "Russian");
		
		
		
		new UserDAO().userMyHome(i, 20, true, "best home you will ever live");
		User user = new UserDAO().getUserById(i);
		
		new UserDAO().UserAddVistedCountries(i, "Russia");
		
		List<String> country = new DaoDemo().countryList(i);
		
		System.out.println("__________________________________________________________________________");
		System.out.println("Overview");
		System.out.println("----------------------------------------");
		System.out.println(user.getFirstName() + " " + user.getLastName()+"        "+ user.getEduction());
		System.out.println(user.getDateOfBirth()+ " " +user.getGender()+"        "+user.getOcupation());
		System.out.println(user.getCity()+"         Date Of Registration "+user.getDateOfRegistration());
		System.out.println();
		System.out.println("My Personal Information");
		System.out.println("----------------------------------------");
		System.out.println("My Email : "+ user.getEmail());
		System.out.println("My Number : " + user.getPhone());
		System.out.println();
		System.out.println("About ME");
		System.out.println("----------------------------------------");
		System.out.println("About me: "+ user.getAboutMe());
		System.out.println("My interest: "+ user.getInterests());
		System.out.println("Why i am here: "+ user.getResonsToSurf());
		System.out.println();
		System.out.println("My Home Discreption");
		System.out.println("----------------------------------------");
		System.out.println(user.getHomeDiscreption());
		System.out.println("Current Hosting Availability :"+user.getCurrentHostingAvailability());
		System.out.println("Max Guests That i Can Have : " + user.getMaxGuests());
		System.out.println();
		System.out.println("Countries i Visited");
		System.out.println("----------------------------------------");
		
		for(String d :country){
			System.out.println(country);
		}
		
	}
}
